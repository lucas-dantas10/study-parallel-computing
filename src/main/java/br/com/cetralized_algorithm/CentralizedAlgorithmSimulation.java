package br.com.cetralized_algorithm;

public class CentralizedAlgorithmSimulation {

    public void execute() {
        CentralCoordinator coordinator = new CentralCoordinator();

        Runnable task = () -> {
            int id = Integer.parseInt(Thread.currentThread().getName());
            boolean entered = false;

            while (!entered) {
                entered = coordinator.requestAccess(id);

                if (!entered) {
                    try {
                        Thread.sleep(100); // Aguarda um tempo para tentar entrar denovo
                    } catch (InterruptedException exception) {
                        Thread.currentThread().interrupt();
                    }
                }
            }

            // Simula um trabalho na seção crítica
            try {
                Thread.sleep(500);
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }

            coordinator.releaseAccess(id);
        };

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(task, String.valueOf(i));
            t.start();
        }
    }
}

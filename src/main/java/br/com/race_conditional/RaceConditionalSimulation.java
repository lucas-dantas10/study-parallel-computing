package br.com.race_conditional;

public class RaceConditionalSimulation {

    private int count = 0;

    public void execute() {
        Runnable tarefa = () -> {
            for (int i = 0; i < 1000; i++) {
                count++; // acesso não sincronizado (condição de corrida)
            }
        };

        Thread t1 = new Thread(tarefa);
        Thread t2 = new Thread(tarefa);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Valor final do count: " + count);
    }
}

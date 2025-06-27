package br.com.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreSimulation {

    public void execute() {
        final int spaces = 3;
        final Semaphore parking = new Semaphore(spaces);

        for (int i = 0; i < 10; i++) {
            int carId = i;

            new Thread(() -> {
                try {
                    System.out.println("Carro " + carId + " tentando estacionar...");
                    parking.acquire();
                    System.out.println("Carro " + carId + " estacionou!");

                    Thread.sleep((long) (Math.random() * 3000));

                    System.out.println("Carro " + carId + " saiu da vaga!");
                    parking.release();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }).start();
        }
    }
}

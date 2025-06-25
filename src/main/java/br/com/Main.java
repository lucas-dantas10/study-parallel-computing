package br.com;

import java.util.concurrent.Semaphore;

public class Main {

    private static int count = 0;
    private static final SimpleMutex mutex = new SimpleMutex();

    public static void main(String[] args) {
        simpleMutexSimulation();
        raceConditionalSimulation();
        semaphoreSimulation();
    }

    public static void simpleMutexSimulation() {
        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    mutex.lock();
                    count++;
                    System.out.println(Thread.currentThread().getName() + " incrementou contador para " + count);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                } finally {
                    mutex.unlock();
                }
            }
        };

        Thread thread = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread.start();
        thread2.start();
    }

    public static void raceConditionalSimulation() {
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

    public static void semaphoreSimulation() {
        final int vagas = 3;
        final Semaphore estacionamento = new Semaphore(vagas);

        for (int i = 0; i < 10; i++) {
            int carroId = i;

            new Thread(() -> {
                try {
                    System.out.println("Carro " + carroId + " tentando estacionar...");
                    estacionamento.acquire();
                    System.out.println("Carro " + carroId + " estacionou!");

                    Thread.sleep((long) (Math.random() * 3000));

                    System.out.println("Carro " + carroId + " saiu da vaga!");
                    estacionamento.release();
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }).start();
        }
    }
}

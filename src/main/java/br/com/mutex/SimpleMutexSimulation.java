package br.com.mutex;

import br.com.SimpleMutex;

public class SimpleMutexSimulation {

    private int count = 0;
    private final SimpleMutex mutex = new SimpleMutex();

    public void execute() {
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
}

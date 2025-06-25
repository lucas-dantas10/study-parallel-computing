package br.com;

public class SimpleMutex {

    private boolean lock = false;

    public synchronized void lock() throws InterruptedException {
        while (lock) {
            wait();
        }

        lock = true;
    }


    public synchronized void unlock() {
        lock = false;
        notify();
    }
}

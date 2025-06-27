package br.com.cetralized_algorithm;

public class CentralCoordinator {

    private boolean resourceBusy = false;

    public synchronized boolean requestAccess(int id) {
        if (!resourceBusy) {
            resourceBusy = true;
            System.out.println("Processo " + id + " entrou na seção crítica.");
            return true;
        }

        return false;
    }

    public synchronized void releaseAccess(int id) {
        resourceBusy = false;
        System.out.println("Processo " + id + " saiu da seção crítica.");
    }
}

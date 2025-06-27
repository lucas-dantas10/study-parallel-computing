package br.com;

import br.com.cetralized_algorithm.CentralizedAlgorithmSimulation;
import br.com.mutex.SimpleMutexSimulation;
import br.com.race_conditional.RaceConditionalSimulation;
import br.com.semaphore.SemaphoreSimulation;

public class Main {

    public static void main(String[] args) {
        new SimpleMutexSimulation().execute();
        new RaceConditionalSimulation().execute();
        new SemaphoreSimulation().execute();
        new CentralizedAlgorithmSimulation().execute();
    }
}

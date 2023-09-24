package nz.ewt;

import nz.ewt.core.SimulationEngine;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("RUNNING...");

        SimulationEngine engine = new SimulationEngine();
        engine.start();
    }
}

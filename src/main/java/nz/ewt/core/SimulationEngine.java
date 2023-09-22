package nz.ewt.core;

import nz.ewt.simvar.SimvarManager;

public class SimulationEngine {
    private final SimvarManager simvarManager;

    public SimulationEngine() {
        simvarManager = new SimvarManager();
    }

    public SimvarManager getSimvarManager() {
        return simvarManager;
    }
}

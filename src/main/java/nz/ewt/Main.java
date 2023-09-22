package nz.ewt;

import nz.ewt.core.SimulationEngine;
import nz.ewt.simvar.SimvarName;

public class Main {

    public static void main(String[] args) {
        System.out.println("RUNNING...");
        SimulationEngine simulationEngine = new SimulationEngine();

        simulationEngine.getSimvarManager().getRecorder().start();
        for (int i = 0; i < 100; i++) {
            simulationEngine.getSimvarManager().setSimvar(SimvarName.ENGINE_RPM, i);
        }

        simulationEngine.getSimvarManager().getRecorder().stop();
        simulationEngine.getSimvarManager().getRecorder().dumpRecording();
    }
}

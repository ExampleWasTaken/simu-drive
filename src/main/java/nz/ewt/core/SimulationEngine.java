package nz.ewt.core;

import nz.ewt.utils.UpdateThrottler;
import nz.ewt.core.hardware.HardwareOrchestrator;
import nz.ewt.core.software.SoftwareOrchestrator;
import nz.ewt.simvar.SimvarManager;

public class SimulationEngine {
    private final HardwareOrchestrator hardwareOrchestrator;
    private final SoftwareOrchestrator softwareOrchestrator;
    private final SimvarManager simvarManager;

    private final UpdateThrottler simulationThrottler;

    private boolean isRunning;

    private DeltaTimeCalculator deltaTimeCalculator;

    /**
     * Sets the update interval of the simulation to 1 ms.
     */
    public SimulationEngine() {
        simvarManager = new SimvarManager();
        hardwareOrchestrator = new HardwareOrchestrator(simvarManager);
        softwareOrchestrator = new SoftwareOrchestrator(simvarManager);
        simulationThrottler = new UpdateThrottler(0);
        deltaTimeCalculator = new DeltaTimeCalculator();
    }

    /**
     * @param updateRate_ms The update interval of the simulation.
     */
    public SimulationEngine(long updateRate_ms) {
        simvarManager = new SimvarManager();
        hardwareOrchestrator = new HardwareOrchestrator(simvarManager);
        softwareOrchestrator = new SoftwareOrchestrator(simvarManager);
        simulationThrottler = new UpdateThrottler(updateRate_ms);
        deltaTimeCalculator = new DeltaTimeCalculator();
    }

    public SimvarManager getSimvarManager() {
        return simvarManager;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void start() {
        isRunning = true;

        hardwareOrchestrator.initialize();
        softwareOrchestrator.initialize();

        simvarManager.getRecorder().start();

        for (int i = 0; i < 4; i++) {
            double deltaTime = this.deltaTimeCalculator.getDeltaTime();

            if (simulationThrottler.canUpdate(deltaTime) == -1) return;

            hardwareOrchestrator.update(deltaTime);
            softwareOrchestrator.update(deltaTime);
        }

        simvarManager.getRecorder().stop();

        softwareOrchestrator.destroy();
        hardwareOrchestrator.destroy();

        simvarManager.getRecorder().dumpRecording();
    }

    public void stop() {
        isRunning = false;
    }

    public long getSimulationRate() {
        return simulationThrottler.getUpdateRate();
    }

    public void setSimulationRate(long simulationRate_ms) {
        simulationThrottler.setUpdateRate(simulationRate_ms);
    }
}

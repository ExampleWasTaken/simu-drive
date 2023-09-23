package nz.ewt.core;

import nz.ewt.common.DeltaTimeCalculator;
import nz.ewt.common.UpdateThrottler;
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
        hardwareOrchestrator = new HardwareOrchestrator();
        softwareOrchestrator = new SoftwareOrchestrator();
        simvarManager = new SimvarManager();
        simulationThrottler = new UpdateThrottler(1);
    }

    /**
     * @param updateRate_ms The update interval of the simulation.
     */
    public SimulationEngine(long updateRate_ms) {
        hardwareOrchestrator = new HardwareOrchestrator();
        softwareOrchestrator = new SoftwareOrchestrator();
        simvarManager = new SimvarManager();
        simulationThrottler = new UpdateThrottler(updateRate_ms);
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

        while(isRunning) {
            double deltaTime = this.deltaTimeCalculator.get();
            hardwareOrchestrator.update(deltaTime);
            softwareOrchestrator.update(deltaTime);
        }

        softwareOrchestrator.destroy();
        hardwareOrchestrator.destroy();
    }

    public void stop() {
        isRunning = false;
    }
}

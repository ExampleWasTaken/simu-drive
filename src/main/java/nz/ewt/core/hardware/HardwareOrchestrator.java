package nz.ewt.core.hardware;

import nz.ewt.car.hardware.engine.Crankshaft;
import nz.ewt.car.hardware.transmission.Transmission;
import nz.ewt.simvar.SimvarManager;

import java.util.ArrayList;
import java.util.List;

public class HardwareOrchestrator {
    private List<HardwareComponent> components;
    private SimvarManager simvarManager;

    public HardwareOrchestrator(SimvarManager simvarManager) {
        components = new ArrayList<>();
        this.simvarManager = simvarManager;
    }

    public void initialize() {
        System.out.println("HW Orchestrator: Initializing...");

        components.add(new Crankshaft(simvarManager));
        components.add(new Transmission(simvarManager));

        for (HardwareComponent current : components) {
            current.initialize();
        }

        System.out.println("HW Orchestrator: Initialized");
    }

    public void update(double deltaTime) {
        for (HardwareComponent current : components) {
            current.update(deltaTime);
        }
    }

    public void destroy() {
        for (HardwareComponent current : components) {
            current.destroy();
        }
    }
}

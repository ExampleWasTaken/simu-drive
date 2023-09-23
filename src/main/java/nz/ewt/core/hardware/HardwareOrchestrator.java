package nz.ewt.core.hardware;

import java.util.ArrayList;
import java.util.List;

public class HardwareOrchestrator {
    private List<HardwareComponent> components;

    public HardwareOrchestrator() {
        components = new ArrayList<>();
    }

    public void addComponent(HardwareComponent component) {
        components.add(component);
    }

    public void initialize() {
        System.out.println("HW Orchestrator: Initializing...");
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

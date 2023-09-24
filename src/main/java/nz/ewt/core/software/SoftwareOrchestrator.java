package nz.ewt.core.software;

import nz.ewt.simvar.SimvarManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SoftwareOrchestrator {
    private List<SoftwareComponent> components;
    private SimvarManager simvarManager;

    public SoftwareOrchestrator(SimvarManager simvarManager) {
        components = new ArrayList<>();
        this.simvarManager = simvarManager;
    }

    public void addComponent(SoftwareComponent component) {
        components.add(component);
    }

    public void initialize() {
        System.out.println("SW Orchestrator: Initializing...");
        for (SoftwareComponent current : components) {
            current.initialize();
        }
        System.out.println("SW Orchestrator: Initialized");
    }

    public void update(double deltaTime) {
        Collections.shuffle(components); // shuffle the list of components to closer simulate real world unpredictability
        for (SoftwareComponent current : components) {
            current.update(deltaTime);
        }
    }

    public void destroy() {
        for (SoftwareComponent current : components) {
            current.destroy();
        }
    }
}

package nz.ewt.core.software;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SoftwareOrchestrator {
    private List<SoftwareComponent> components;

    public SoftwareOrchestrator() {
        components = new ArrayList<>();
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

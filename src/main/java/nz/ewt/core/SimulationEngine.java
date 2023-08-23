package nz.ewt.core;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine {
    private boolean isRunning;

    private long lastUpdateTime;

    private final List<Simulatable> components;

    public SimulationEngine() {
        this.isRunning = false;
        this.lastUpdateTime = 0;
        this.components = new ArrayList<>();
    }

    public void addComponent(Simulatable component) {
        this.components.add(component);
    }

    public void start() {
        this.isRunning = true;
        this.lastUpdateTime = System.nanoTime();

        while(isRunning) {
            long currentTime = System.nanoTime();
            double deltaTime = (currentTime - this.lastUpdateTime) / 1e9;

            this.updateComponents(deltaTime);

            this.lastUpdateTime = currentTime;
        }
    }

    public void stop() {
        this.isRunning = false;
    }

    private void updateComponents(double deltaTime) {
        for (Simulatable current : components) {
            current.update(deltaTime);
        }
    }
}

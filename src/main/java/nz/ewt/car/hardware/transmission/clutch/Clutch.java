package nz.ewt.car.hardware.transmission.clutch;

import nz.ewt.core.hardware.HardwareComponent;
import nz.ewt.simvar.SimvarManager;

import java.util.ArrayList;
import java.util.List;

public class Clutch implements HardwareComponent {
    private List<HardwareComponent> components;
    private SimvarManager simvarManager;

    public Clutch(SimvarManager simvarManager) {
        components = new ArrayList<>();
        this.simvarManager = simvarManager;
    }

    @Override
    public void initialize() {
        System.out.println("Initializing clutch...");

        components.add(new EngineClutchDisk(simvarManager));
        components.add(new TransmissionClutchDisk(simvarManager));

        initializeComponents(components);

        System.out.println("Clutch initialized");
    }

    @Override
    public void update(double deltaTime) {
        updateComponents(components, deltaTime);
    }

    @Override
    public SimvarManager getSimvarManager() {
        return simvarManager;
    }
}

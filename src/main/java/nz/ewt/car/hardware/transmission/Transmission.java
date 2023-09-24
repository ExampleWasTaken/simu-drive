package nz.ewt.car.hardware.transmission;

import nz.ewt.car.hardware.transmission.clutch.Clutch;
import nz.ewt.core.hardware.HardwareComponent;
import nz.ewt.simvar.SimvarManager;

import java.util.ArrayList;
import java.util.List;

public class Transmission implements HardwareComponent {
    private SimvarManager simvarManager;
    private List<HardwareComponent> components;

    public Transmission(SimvarManager simvarManager) {
        this.simvarManager = simvarManager;
        components = new ArrayList<>();
    }

    @Override
    public void initialize() {
        System.out.println("Initializing transmission...");

        components.add(new Clutch(simvarManager));
        components.add(new Gearbox(simvarManager));

        initializeComponents(components);

        System.out.println("Transmission initialized.");
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

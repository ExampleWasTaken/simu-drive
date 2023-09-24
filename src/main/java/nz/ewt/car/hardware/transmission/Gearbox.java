package nz.ewt.car.hardware.transmission;

import nz.ewt.core.hardware.HardwareComponent;
import nz.ewt.simvar.SimvarManager;

import java.util.ArrayList;
import java.util.List;

public class Gearbox implements HardwareComponent {
    private SimvarManager simvarManager;
    private List<HardwareComponent> components;

    public Gearbox(SimvarManager simvarManager) {
        this.simvarManager = simvarManager;
        components = new ArrayList<>();
    }

    @Override
    public void initialize() {
        System.out.println("Initializing gearbox...");

        components.add(new InputShaft(simvarManager));

        initializeComponents(components);

        System.out.println("Gearbox initialized");
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

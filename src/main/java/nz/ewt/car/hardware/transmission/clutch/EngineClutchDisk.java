package nz.ewt.car.hardware.transmission.clutch;

import nz.ewt.core.hardware.RotationalComponent;
import nz.ewt.simvar.SimvarManager;
import nz.ewt.simvar.SimvarName;

public class EngineClutchDisk implements RotationalComponent {
    private double angle;

    private SimvarManager simvarManager;

    public EngineClutchDisk(SimvarManager simvarManager) {
        this.simvarManager = simvarManager;
    }

    @Override
    public void initialize() {
        System.out.println("Initializing engine clutch disk...");

        simvarManager.setSimvar(SimvarName.TRANS_CLUTCH_1_ENGINE_DISK_ANGLE, angle);

        System.out.println("Engine clutch disk initialized");
    }

    @Override
    public void update(double deltaTime) {
        angle = (double) simvarManager.getSimvar(SimvarName.CRANKSHAFT_ANGLE);

        simvarManager.setSimvar(SimvarName.TRANS_CLUTCH_1_ENGINE_DISK_ANGLE, angle);
    }

    @Override
    public SimvarManager getSimvarManager() {
        return simvarManager;
    }

    @Override
    public double getAngle() {
        return angle;
    }
}

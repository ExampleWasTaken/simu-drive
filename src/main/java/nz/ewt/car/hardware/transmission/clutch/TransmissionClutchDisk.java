package nz.ewt.car.hardware.transmission.clutch;

import nz.ewt.core.hardware.RotationalComponent;
import nz.ewt.simvar.SimvarManager;
import nz.ewt.simvar.SimvarName;

public class TransmissionClutchDisk implements RotationalComponent {
    private double angle;
    private SimvarManager simvarManager;

    public TransmissionClutchDisk(SimvarManager simvarManager) {
        angle = 0;
        this.simvarManager = simvarManager;
    }
    @Override
    public void initialize() {
        System.out.println("Initializing transmission side clutch disk...");

        simvarManager.setSimvar(SimvarName.TRANS_CLUTCH_1_TRANS_DISK_ANGLE, angle);

        System.out.println("Transmission side clutch disk initialized");
    }

    @Override
    public void update(double deltaTime) {
        // TODO: for now the clutch is always considered engaged. Logic for slipping etc. should be in here and take values from the simvar storage.
        angle = (double) simvarManager.getSimvar(SimvarName.TRANS_CLUTCH_1_ENGINE_DISK_ANGLE);

        simvarManager.setSimvar(SimvarName.TRANS_CLUTCH_1_TRANS_DISK_ANGLE, angle);
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

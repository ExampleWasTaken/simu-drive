package nz.ewt.car.hardware.transmission;

import nz.ewt.core.hardware.RotationalComponent;
import nz.ewt.simvar.SimvarManager;
import nz.ewt.simvar.SimvarName;

public class InputShaft implements RotationalComponent {
    private SimvarManager simvarManager;
    private double angle;

    public InputShaft(SimvarManager simvarManager) {
        this.simvarManager = simvarManager;
        angle = 0;
    }

    @Override
    public void initialize() {
        System.out.println("Initializing input shaft...");

        simvarManager.setSimvar(SimvarName.TRANS_INPUT_SHAFT_1_ANGLE, angle);

        System.out.println("InputShaft initialized");
    }

    @Override
    public void update(double deltaTime) {
        angle = (double) simvarManager.getSimvar(SimvarName.TRANS_CLUTCH_1_TRANS_DISK_ANGLE);

        simvarManager.setSimvar(SimvarName.TRANS_INPUT_SHAFT_1_ANGLE, angle);
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

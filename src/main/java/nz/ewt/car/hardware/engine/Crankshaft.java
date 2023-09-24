package nz.ewt.car.hardware.engine;

import nz.ewt.core.hardware.RotationalComponent;
import nz.ewt.simvar.SimvarManager;
import nz.ewt.simvar.SimvarName;
import nz.ewt.utils.Angle;

public class Crankshaft implements RotationalComponent {
    private SimvarManager simvarManager;
    private double angle;

    public Crankshaft(SimvarManager simvarManager) {
        this.simvarManager = simvarManager;
        angle = 0;
    }

    @Override
    public void initialize() {
        System.out.println("Initializing crankshaft...");

        simvarManager.setSimvar(SimvarName.CRANKSHAFT_ANGLE, angle);

        System.out.println("Crankshaft initialized");
    }

    @Override
    public void update(double deltaTime) {
        angle = Angle.wrap(angle, calculateRadiansPerUpdateCycle(700, deltaTime));

        simvarManager.setSimvar(SimvarName.CRANKSHAFT_ANGLE, angle);
    }

    @Override
    public SimvarManager getSimvarManager() {
        return simvarManager;
    }

    @Override
    public double getAngle() {
        return angle;
    }

    // TODO: this will have to be changed as the crankshaft cannot know its RPM. However, as there is not engine simulation in place right now this will do.
    private double calculateRadiansPerUpdateCycle(double rpm, double deltaTime) {
        double radiansPerSecond = (rpm * Angle.TWO_PI) / 60;
        return radiansPerSecond * deltaTime;
    }
}

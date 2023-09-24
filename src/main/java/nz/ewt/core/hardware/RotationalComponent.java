package nz.ewt.core.hardware;

/**
 * Represents any hardware component that rotates.
 */
public interface RotationalComponent extends HardwareComponent {
    /**
     * @return The current angle of the component in radians.
     */
    double getAngle();
}

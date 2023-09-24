package nz.ewt.utils;

/**
 * Utility class for handling angles. <br>
 * All values are considered in radians. For degrees use the {@link Degree} class.
 */
public class Angle {
    public static double TWO_PI = 2 * Math.PI;

    /**
     * Add or subtract an angle to another angle. <br>
     * <br>
     * This method performs the following operation: <br>
     * <br>
     * {@code angleOne + angleTwo} while making sure the angle never exceeds 2π. If it does it will wrap around to the corresponding
     * value one the circle.
     * @param angleOne The angle to add or subtract to or from.
     * @param angleTwo The angle that should be added or subtracted to or from the other.
     * @return The result of the operation, but wrapped if need be.
     */
    public static double wrap(double angleOne, double angleTwo) {
        double sumAngle = angleOne + angleTwo;
        double wrappedAngle = sumAngle % TWO_PI;
        return wrappedAngle >= 0 ? wrappedAngle : wrappedAngle + TWO_PI;
    }

    public static double calculateRadiansPerUpdateCycle(double rpm, double deltaTime) {
        double radiansPerSecond = (rpm * Angle.TWO_PI) / 60;
        return radiansPerSecond * deltaTime;
    }

    /**
     * This class is a mirror to {@link Angle} but all methods expect degree values.
     */
    public static class Degree {

        /**
         * See {@link Angle#wrap(double, double)} for documentation.
         */
        public static double wrap(double angleOne, double angleTwo) {
            double sumAngle = angleOne + angleTwo;
            double wrappedAngle = sumAngle % 360;
            return wrappedAngle >= 0 ? wrappedAngle : wrappedAngle + 360;
        }
    }
}

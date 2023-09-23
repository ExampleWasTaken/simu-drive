package nz.ewt.common;

public class DeltaTimeCalculator {
    private long currentTime;
    private long lastUpdateTime;
    private double deltaTime;

    public DeltaTimeCalculator() {
        currentTime = System.currentTimeMillis();
        lastUpdateTime = 0;
        deltaTime = 0;
    }

    public double get() {
        currentTime = System.currentTimeMillis();
        deltaTime = currentTime - lastUpdateTime;
        lastUpdateTime = currentTime;
        return deltaTime;
    }
}

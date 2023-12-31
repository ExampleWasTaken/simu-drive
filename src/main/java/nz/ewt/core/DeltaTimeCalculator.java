package nz.ewt.core;

public class DeltaTimeCalculator {
    private long currentTime;
    private long lastUpdateTime;
    private double deltaTime;

    public DeltaTimeCalculator() {
        currentTime = System.currentTimeMillis();
        lastUpdateTime = 0;
        deltaTime = 0;
    }

    public double getDeltaTime() {
        currentTime = System.currentTimeMillis();
        deltaTime = currentTime - lastUpdateTime;
        lastUpdateTime = currentTime;
        return deltaTime;
    }
}

package nz.ewt.common;

public class UpdateThrottler {
    private long updateRate_ms;
    private double accumulatedDeltaTime;

    public UpdateThrottler(long updateRate_ms) {
        this.updateRate_ms = updateRate_ms;
        accumulatedDeltaTime = 0;
    }

    public long getUpdateRate() {
        return updateRate_ms;
    }

    public void setUpdateRate(long updateRate_ms) {
        this.updateRate_ms = updateRate_ms;
    }

    /**
     * @param deltaTime The time that has passed since the last update cycle.
     * @return -1 if the component should not update, otherwise the elapsed time since the component this throttler belongs to has updated.
     */
    public double canUpdate(double deltaTime) {
        accumulatedDeltaTime += deltaTime;
        if (accumulatedDeltaTime >= updateRate_ms) {
            double timeSinceLastUpdate = accumulatedDeltaTime;
            accumulatedDeltaTime = 0;
            return timeSinceLastUpdate;
        }

        return -1;
    }
}

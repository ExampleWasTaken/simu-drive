package nz.ewt.core.software;

import nz.ewt.common.UpdateThrottler;

public interface SoftwareComponent {
    void initialize();
    void update(double deltaTime);
    default void destroy() {
    }
    UpdateThrottler getThrottler();
}

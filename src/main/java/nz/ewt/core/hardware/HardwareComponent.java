package nz.ewt.core.hardware;

public interface HardwareComponent {
    void initialize();
    void update(double deltaTime);

    default void destroy() {
    }
}

package nz.ewt.core.hardware;

/**
 * Represents a hardware component meaning it is managed by the {@link nz.ewt.core.hardware.HardwareOrchestrator} and runs
 * at simulation speed.
 */

import nz.ewt.core.common.Component;

import java.util.List;

public interface HardwareComponent extends Component {
    default void initializeComponents(List<HardwareComponent> components) {
        for (HardwareComponent current : components) {
            current.initialize();
        }
    }
    default void updateComponents(List<HardwareComponent> components, double deltaTime) {
        for (HardwareComponent current : components) {
            current.update(deltaTime);
        }
    }
}

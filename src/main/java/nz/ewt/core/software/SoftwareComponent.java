package nz.ewt.core.software;

import nz.ewt.utils.UpdateThrottler;
import nz.ewt.core.common.Component;

/**
 * Represents any software component.
 */
public interface SoftwareComponent extends Component {
    /**
     * Get the throttler instance throttling this component.
     * @return The {@link UpdateThrottler} instance of this component or null if the component does not have a throttler.
     */
    default UpdateThrottler getThrottler(){
        return null;
    }
}

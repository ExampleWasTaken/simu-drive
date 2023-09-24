package nz.ewt.core.common;

import nz.ewt.simvar.SimvarManager;

/**
 * Represents any component of the simulation.
 */
public interface Component {
    /**
     * Called before the simulation loop is started.
     */
    void initialize();

    /**
     * Called once per update cycle.
     * @param deltaTime The delta time of the simulation. Meaning the elapsed time since the last update cycle.
     */
    void update(double deltaTime);

    /**
     * @return Get the {@link SimvarManager} the components uses.
     */
    SimvarManager getSimvarManager();

    /**
     * Called after the simulation loop has exited.
     */
    default void destroy(){
    }
}

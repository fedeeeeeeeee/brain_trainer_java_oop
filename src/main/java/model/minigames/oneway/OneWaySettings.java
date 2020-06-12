package model.minigames.oneway;

/**
 * The interface to change One Way settings.
 *
 */
public interface OneWaySettings {

    /**
     * 
     * @return the arrows count
     */
    int getArrows();

    /**
     * 
     * @return the grid size
     */
    int getSize();

    /**
     * 
     * @return the timer duration
     */
    int getSeconds();
}

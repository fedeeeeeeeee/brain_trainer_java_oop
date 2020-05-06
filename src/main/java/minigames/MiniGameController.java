package minigames;

/**
 * 
 * This interface represents the common parts of
 * the minigame view.
 *
 */
public interface MiniGameController {

    /**
     * Update the seconds of the timer on the view.
     * 
     * @param second
     */
    void updateTimerView(int second);

    /**
     * Indicates that the time available is finished.
     */
    void timeFinsh();
}


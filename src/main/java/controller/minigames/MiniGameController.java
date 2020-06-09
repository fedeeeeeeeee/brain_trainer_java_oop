package controller.minigames;

/**
 * This interface represents the common parts of the minigame controller.
 *
 */
public interface MiniGameController {

    /**
     * Update the seconds of the timer on the view.
     * 
     * @param second 
     *              the seconds of the timer
     */
    void updateTimerView(int second);

    /**
     * Indicate that the time available is finished.
     */
    void timeFinish();
    
}

package controller.minigames;

/**
 * This interface represents the common parts of the minigame controller.
 *
 */
public interface MiniGameController {
    
    /**
     * Start the {@link GameTimer}.
     */
    void startTimer();

    /**
     * Stop the {@link GameTimer}.
     */
    void stopTimer();
    
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

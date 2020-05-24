package controller.minigames.perilouspath;

/**
 * Represents the Perilous Path Controller.
 */
public interface PerilousPathController {

    /**
     * Initialize the game.
     */
    void startGame();

    /**
     * Check if the user can hit this position.
     * 
     * @param row
     * @param col
     */
    void hitAttempt(int row, int col);

    /**
     * Reset the view at the initial state.
     */
    void resetView();

    /**
     * The time of the secondary timer is expired. 
     */
    void secondaryTimerExpired();

    /**
     * The time of the primary timer is expired.
     */
    void timerExpired();
}

package controller.minigames.perilouspath;

import controller.minigames.MiniGameController;

/**
 * Represents the Perilous Path Controller.
 */
public interface PerilousPathController extends MiniGameController {

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
     * Update the view.
     */
    void updateView();

    /**
     * Reset the view at the initial state.
     */
    void resetView();

    /**
     * Start the timer of the game.
     */
    void startTimer();

    /**
     * Stop the timer of the game.
     */
    void stopTimer();

    /**
     * The time of the secondary timer is expired. 
     */
    void secondaryTimerExpired();
}

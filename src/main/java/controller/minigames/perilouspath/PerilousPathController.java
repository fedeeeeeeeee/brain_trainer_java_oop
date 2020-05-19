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
     * The time is expired.
     */
    void timerExpired();
}

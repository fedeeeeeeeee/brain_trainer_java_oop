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
     * The time is expired.
     */
    void timerExpired();
}

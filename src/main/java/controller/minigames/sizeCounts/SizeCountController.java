package controller.minigames.sizeCounts;

/**
 * 
 * A interface controller for the game size count.
 *
 */
public interface SizeCountController {

    /**
     * Resets the game for a new match.
     */
    void resetGame();

    /**
     * Informs the model of the new attempt of the user.
     * 
     * @param answer
     */
    void newAttempt(String answer);

    /**
     * The time is expired so the game must ended.
     */
    void timeExpired();

    /**
     * Asks the model to compute new operations.
     */
    void computeOperations();


}

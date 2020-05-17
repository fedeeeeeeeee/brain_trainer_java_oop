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
     * Requires the model the score.
     */
    void computeScore();

    /**
     * Asks the model to compute new operations.
     */
    void computeOperations();

}

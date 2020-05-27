package controller.minigames.colorgama;

/**
 * The controller interface of ColorGama minigame.
 *
 */
public interface ColorGamaController {

    /**
     * Start ColorGama minigame.
     */
    void startGame();

    /**
     * The time is expired. 
     * 
     */
    void timeExpired();

    /**
     * Check the response given by the user.
     * 
     * @param index
     *          the button's index 
     */
    void checkAnswer(int index);

    /**
     * Reset the game for the next level.
     */
    void nextLevel();
}

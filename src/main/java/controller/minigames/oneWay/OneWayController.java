package controller.minigames.oneWay;

import controller.minigames.MiniGameController;

/**
 * The interface for the One Way controller. 
 *
 */
public interface OneWayController extends MiniGameController {

    /**
     * Check if the player guess the answer.
     * @param x
     *        x coordinate to check
     * @param y
     *        y coordinate to check
     */
    void hit(int x, int y);

    /**
     * Show the end game scene.
     */
    void timeExpired();

    /**
     * Initialize the next level.
     */
    void nextLevel();

    /**
     * Initialize the game at its first initialization.
     */
    void firstInit();

    /**
     * Show if the player guess the answer.
     */
    void showSolution();

    /**
     * Stop the timer of the game.
     */
    void stopTimer();

    /**
     * Start the timer of the game.
     */
    void startTimer();

}

package view.controllers.minigames;

import view.controllers.FxController;

/** 
 * This interface represents the common parts of the minigame view.
 *
 */
public interface FxMiniGameController extends FxController {

    /**
     * Show the seconds of the timer on the view.
     * 
     * @param second 
     *              the seconds of the timer
     */
    void showTimerSeconds(int second);

    /**
     * Initialize the current minigame with specific settings.
     * 
     */
    void initGame();

    /**
     * Show the end game scene.
     * 
     * @param finalScore
     *              the score of the minigame
     */
    void showEndGame(int finalScore);

    /**
     * Set the initial seconds.
     * 
     * @param initialSeconds
     *          initialSeconds of the timer
     */
    void setInitialSeconds(int initialSeconds);

    /**
     * Stop timer.
     */
    void stopTimer();
}

package view.controllers.minigames;

import view.controllers.FxController;

/** 
 * This interface represents the common parts of the minigame view.
 *
 */
public interface FxMiniGameController extends FxController {

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

    /**
     * Initialize the current minigame with specific settings.
     * 
     */
    void initGame();

}

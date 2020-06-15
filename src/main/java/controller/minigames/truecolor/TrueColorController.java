package controller.minigames.truecolor;

import controller.minigames.MiniGameController;

/**
 * 
 * A interface controller for the game True Color.
 *
 */
public interface TrueColorController extends MiniGameController {

    /**
     * Builds and transfer the useful elements to the View.
     */
    void startGame();

    /**
     * 
     * Reload the map containing the random color for the button.
     * 
     */
    void refresh();

    /**
     * Check if is the right answer.
     * 
     * @param selectedAnswer answer to check
     * 
     */
    void check(String selectedAnswer);
}

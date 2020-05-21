package view.controllers.minigames.colorgama;

import model.minigames.colorgama.ComputeColor;

/**
 * The view interface of ColorGama minigame.
 *
 */
public interface ColorGamaFx {

    /**
     * Switch to the end scene of the game.
     * 
     * @param finalScore
     *          the final score obtained
     */
    void endGame(int finalScore);

    /**
     * Fill a grid with buttons.
     *
     * @param size
     *          the grid size
     *
     * @param computeColor 
     *          the colors of buttons
     */
    void drawGrid(int size, ComputeColor computeColor);

    /**
     * Show the next level.
     * 
     * @param computeColor
     *          the colors of buttons
     */
    void showNext(ComputeColor computeColor);

    /**
     * Show the tick image.
     */
    void rightAnswer();

    /**
     * Show the cross image. 
     */
    void wrongAnswer();
}

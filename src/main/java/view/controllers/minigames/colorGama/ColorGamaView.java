package view.controllers.minigames.colorGama;

/**
 * The view interface of ColorGama minigame.
 *
 */
public interface ColorGamaView {

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
     */
    void drawGrid(int size);
}

package view.controllers.minigames.perilouspath;

/**
 * Represents the Perilous Path View.
 */
public interface PerilouPathFx {

    /**
     * Draw the grid.
     * 
     * @param size
     *            the size of the grid
     */
    void drawGrid(int size);

    /**
     * Show the final score.
     * 
     * @param finalScore
     */
    void endGame(int finalScore);

}

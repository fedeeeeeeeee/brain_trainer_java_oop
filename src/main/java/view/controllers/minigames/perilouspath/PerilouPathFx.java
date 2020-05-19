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
     * Shows the step taken by the user.
     * 
     * @param row
     * @param col
     */
    void showStep(int row, int col);

    /**
     * Shows the final score.
     * 
     * @param finalScore
     */
    void endGame(int finalScore);

}

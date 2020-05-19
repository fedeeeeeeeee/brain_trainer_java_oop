package view.controllers.minigames.perilouspath;

import java.util.Set;

import utility.Pair;

/**
 * Represents the Perilous Path View.
 */
public interface PerilouPathFx {

    /**
     * Draw the grid.
     * 
     * @param size
     */
    void drawGrid(int size);

    /**
     * Shows the starting point from which the user must depart.
     * 
     * @param start
     */
    void showStart(Pair<Integer, Integer> start);

    /**
     * Shows the target that the user must reach.
     * 
     * @param finish
     */
    void showFinish(Pair<Integer, Integer> finish);

    /**
     * Shows the mines that the user must avoid.
     * 
     * @param mines
     */
    void showMines(Set<Pair<Integer, Integer>> mines);

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

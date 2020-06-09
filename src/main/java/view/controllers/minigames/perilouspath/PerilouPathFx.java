package view.controllers.minigames.perilouspath;

import java.util.Set;

import model.minigames.perilouspath.Mine;
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
    void draw(int size);

    /**
     * Wait a few milliseconds to show the mines or a mine explosion.
     * 
     * @param millis
     *              milliseconds it has to wait
     * @param mineExplosion
     *              true if the mine is exploded, false otherwise
     */
    void animation(int millis, boolean mineExplosion);

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
    void showMines(Set<Mine> mines);

    /**
     * Shows the step of the path taken by the user.
     * 
     * @param row
     * @param col
     */
    void showStep(int row, int col);

    /**
     * Shows the mine exploded.
     * 
     * @param row
     * @param col
     */
    void showExplosion(int row, int col);

    /**
     * Restore the view.
     */
    void restore();
}

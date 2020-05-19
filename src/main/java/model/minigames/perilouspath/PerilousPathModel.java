package model.minigames.perilouspath;

import java.util.Set;

import utility.Pair;

/**
 * Represents the Perilous Path Model.
 */
public interface PerilousPathModel {

    /**
     * Check if the user can hit this position.
     * 
     * @param row
     * @param col
     * @return true if user can hit this coordinate, false otherwise
     */
    boolean hit(int row, int col);

    /**
     * Gets the size of this current level.
     * 
     * @return the size
     */
    int getSize();

    /**
     * Initialize the start position.
     */
    void initStart();

    /**
     * Initialize the finish position.
     */
    void initFinish();

    /**
     * Initialize the mines position.
     */
    void initMines();

    /**
     * Gets the start position.
     * 
     * @return the start coordinate
     */
    Pair<Integer, Integer> getStart();

    /**
     * Gets the finish position.
     * 
     * @return the finish coordinate
     */
    Pair<Integer, Integer> getFinish();

    /**
     * Gets the mines position.
     * 
     * @return a set of mines' coordinate
     */
    Set<Pair<Integer, Integer>> getMines();

    /**
     * Add point when user finds the right path.
     */
    void addPoint();

    /**
     * Gets the game's final score.
     * 
     * @return the final score
     */
    int getFinalScore();

    /**
     * Check if the user finds a path correctly.
     * 
     * @return true if the user hasn't made a mistake, false otherwise
     */
    boolean isDone();

    /**
     * Check if the user fails.
     * 
     * @return true if the user has made a mistake, false otherwise
     */
    boolean isFailed();

    /**
     * Reset the game.
     */
    void reset();
}

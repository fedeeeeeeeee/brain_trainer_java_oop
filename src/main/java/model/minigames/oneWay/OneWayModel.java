package model.minigames.oneWay;

import java.util.List;
import model.DifficultyLevel;
import utility.Pair;

/**
 * The model interface of One Way minigame.
 * 
 */
public interface OneWayModel {

    /**
     * Check if the player guess the answer.
     * @param row
     *          x coordinate 
     * @param col
     *          y coordinate 
     * @return true if player hit the final position, false otherwise.
     */
    boolean hitFinalPosition(int row, int col);

    /**
     * 
     * @return the selected {@link DifficultyLevel}
     */
    DifficultyLevel getDifficulty();

    /**
     * 
     * @return the size of the grid to draw
     */
    int getSize();

    /**
     * 
     * @return the list of generated {@link Direction} 
     */
    List<Direction> getSteps();

    /**
     * 
     * @return the initial position
     */
    Pair<Integer, Integer> getInitialPosition();

    /**
     * 
     * @return the final position
     */
    Pair<Integer, Integer> getFinalPosition();

    /**
     * Add scored points. 
     * 
     */
    void addPoint();

    /**
     * 
     * @return the final score
     */
    int getFinalScore();

    /**
     * Initialize One Way.
     * 
     */
    void oneWayInit();

    /**
     * 
     * @return the arrows count
     */
    int getArrowsCount();

    /**
     * 
     * @return the seconds of the game
     */
    int getSeconds();

}

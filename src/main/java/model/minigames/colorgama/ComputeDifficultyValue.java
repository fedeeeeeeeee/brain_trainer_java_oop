package model.minigames.colorgama;

/**
 * This interface calculates constants according to the difficulty.
 *
 */
public interface ComputeDifficultyValue {

    /**
     * Get the size of the grid of buttons.
     * 
     * @return size
     *          a grid size
     */
    int getGridSize();

    /**
     * Get the base point of minigame.
     *
     * @return point
     *          base point
     */
    int getBasePoint();

    /**
     * Get the seconds according to the difficulty.
     * 
     * @return seconds
     *          seconds of the game
     */
    int getSeconds();


    /**
     * Get the number of different color to show.
     * 
     * @return colors
     *          the number of the color
     */
    int getNumColor();
}

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
     * Get the number of different color to show.
     * 
     * @return colors
     *          the number of the color
     */
    int getNumColor();

    /**
     * Get of the random origin of the color value.
     * 
     * @return origin
     *           the origin of each random value
     */
    int getRandomColorOrigin();

    /**
     * Get of the random bound of the color value.
     * 
     * @return bound
     *           the bound of each random value
     */
    int getRandomColorBound();

    /**
     * Get the range of the hue component.
     * 
     * @return range
     *          the range of the hue
     */
    int getValueRange();

    /**
     * Get the seconds according to the difficulty.
     * 
     * @return seconds
     *          seconds of the game
     */
    int getSeconds();
}

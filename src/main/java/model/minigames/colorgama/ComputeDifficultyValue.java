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
     * Get the range value for the color.
     * 
     * @return range
     *          the range of color
     */
    double getColorRange();

    /**
     * Get of the random origin of the color value.
     * 
     * @return origin
     *           the origin of each random value
     */
    double getRandomColorOrigin();

    /**
     * Get of the random bound of the color value.
     * 
     * @return bound
     *           the bound of each random value
     */
    double getRandomColorBound();

    /**
     * Get a specified precision and rounding mode.
     * 
     * @return context
     *          representing the math context settings
     */
    String contextSettings();

    /**
     * Get the range of the hue component.
     * 
     * @return range
     *          the range of the hue
     */
    int getHueRange();

    /**
     * Get the seconds according to the difficulty.
     * 
     * @return seconds
     *          seconds of the game
     */
    int getSeconds();

}

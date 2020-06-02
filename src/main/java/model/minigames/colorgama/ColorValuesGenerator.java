package model.minigames.colorgama;

/**
 * This interface represents a calculator of the hsb values of the colors.
 *
 */
public interface ColorValuesGenerator {

    /**
     * Get a random hue component of the color between 0 (inclusive) and 361 (exclusive).
     * 
     * @return hue
     *          the hue value in degrees
     */
    Integer getRandomH();

    /**
     * Get a random hue value between 0 (inclusive) and the specified value
     * (exclusive).
     * 
     * @param bound 
     *          the upper bound (exclusive). Must be positive and less than or
     *          equal to {@code 361}.
     *
     * @return hue the hue value in degrees
     */
    Integer getRandomH(int bound);

    /**
     * Get a random saturation or brightness component of the color. 
     * 
     * @return saturation or brightness
     *          the saturation or brightness value
     */
    Double getRandomSB();

    /**
     * Get a random saturation or brightness component of the color between to the
     * given origin (inclusive) and bound(exclusive).
     * 
     * @param origin
     *          the origin (inclusive) of the saturation or brightness value.
     *          Must be greater than or equal to {@code 0.0} 
     *
     * @param bound
     *          the bound (exclusive) of the saturation or brightness value
     *          Must be less than or equal to {@code 0.0}
     *
     * @return saturation or brightness
     *          the saturation or brightness value
     */
    Double getRandomSB(double origin, double bound);
}

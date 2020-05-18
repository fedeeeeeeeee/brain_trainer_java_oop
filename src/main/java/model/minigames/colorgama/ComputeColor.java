package model.minigames.colorgama;

/**
 * This interface calculates the hsb values of the colors to put.
 *
 */
public interface ComputeColor {

    /**
     * Get the hue value of a random color.
     * 
     * @return hue
     *          the hue in degrees
     *
     */
    double getHue();

    /**
     * Get the saturation value of a random color.
     * 
     * @return saturation
     *          the saturation component
     */
    double getSaturation();

    /**
     * Get the brightness value of a random color.
     * 
     * @return brightness
     *          the brightness component
     */
    double getBrightness();

    /**
     * Get the hue value of the right color.
     * 
     * @return hue
     *          the hue in degrees
     *
     */
    double getRightHue();

    /**
     * Get the hue value of the right color.
     * 
     * @return saturation
     *          the saturation component
     */
    double getRightSaturation();

    /**
     * Get the hue value of the right color.
     * 
     * @return brightness
     *          the brightness component
     */
    double getRightBrightness();

    /**
     * Reset all values according to the question.
     * 
     * @param question
     *          the question indicated
     */
    void reset(QuestionType question);
}

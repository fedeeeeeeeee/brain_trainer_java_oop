package model.minigames.colorgama;

import java.util.Optional;

/**
 * This interface calculates the values of the colors for the minigame.
 *
 */
public interface ColorValuesCalculator {

    /**
     * Get a the random color values.
     * 
     * @return colorValues
     *          the color values of a random color
     */
    ColorValues<?> getRandomColorValues();

    /**
     * Calculates the right color values.
     *
     * @param question
     *          the current question.
     *
     * @return colorValues
     *          the color values of the right color
     */
    Optional<ColorValues<?>> calculateRightColor(QuestionType question);

    /**
     * Reset all values.
     * 
     */
    void reset();
}

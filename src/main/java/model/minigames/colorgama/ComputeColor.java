package model.minigames.colorgama;

import org.apache.commons.lang3.tuple.Triple;

/**
 * This interface calculates the hsb values of the colors to put.
 *
 */
public interface ComputeColor {

    /**
     * Get a triple of the random color values.
     * 
     * @return triple
     *          the hsb component of the color
     */
    Triple<Integer, Double, Double> nextColorValues();

    /**
     * Calculates the right color values.
     *
     * @param question
     *          the current question
     */
    void calculateRightValues(QuestionType question);

    /**
     * Get a index of the right color.
     * 
     * @return index
     *          right color's index
     */
    int getRightColorIndex();

    /**
     * Get a triple of the right color values.
     * 
     * @return values
     *          the hsb component of the right color
     */
    Triple<Integer, Double, Double> getRightColor();

    /**
     * Reset all values according to the question.
     * 
     */
    void reset();

}

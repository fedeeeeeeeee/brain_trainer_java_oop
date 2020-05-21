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
     * Get a triple of the right color values.
     * 
     * @param question
     *          the current question
     *
     * @return triple
     *          the hsb component of the color
     *
     */
    int getRightColorIndex(QuestionType question);

    /**
     * Reset all values according to the question.
     * 
     */
    void reset();
}

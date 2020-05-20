package model.minigames.colorgama;

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
    Triple<Integer, Double, Double> getRightColorValues(QuestionType question);

    /**
     * Reset all values according to the question.
     * 
     */
    void reset();
}

package model.minigames.colorgama;

import org.apache.commons.lang3.tuple.Triple;

/**
 * The model interface of ColorGama minigame.
 *
 */
public interface ColorGamaModel {

    /**
     * Add points when the user gave the right answer.
     */
    void addPoint();

    /**
     * Get the final score.
     * 
     * @return score
     */
    int getFinalScore();

    /**
     * Get the constants according to the difficulty.
     * 
     * @return
     *      Compute
     */
    ComputeDifficultyValue getDifficultyValue();

    /**
     * Get the color calculator.
     * 
     * @return colors
     *          colors to fill the buttons
     */
    ComputeColor getComputeColor();

    /**
     * Get the index of the right answers.
     * 
     * @return index
     *          right index
     */
    int getRightIndex();

    /**
     * Get the values of the right color.
     * 
     * @return values
     *          a hsb value
     */
    Triple<Integer, Double, Double> getRightColorValues();

    /**
     * Get the type of the current question.
     * 
     * @return question
     *          current question
     */
    QuestionType getCurrentQuestion();

    /**
     * Set the next question.
     */
    QuestionType nextQuestion();

    /**
     * 
     */
    void setRightColorValue();

}

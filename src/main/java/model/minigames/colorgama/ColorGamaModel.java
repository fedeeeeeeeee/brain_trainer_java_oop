package model.minigames.colorgama;

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
     * Set the next question.
     */
    void nextQuestion();

}

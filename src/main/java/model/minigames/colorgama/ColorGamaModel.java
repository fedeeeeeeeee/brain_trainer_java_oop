package model.minigames.colorgama;

import model.minigames.MiniGameModel;

/**
 * The model interface of ColorGama minigame.
 *
 */
public interface ColorGamaModel extends MiniGameModel {

    /**
     * Get the constants according to the difficulty.
     * 
     * @return difficultyValues
     *          values of the minigame
     */
    ComputeDifficultyValue getDifficultyValue();

    /**
     * Get the color iterator.
     * 
     * @return colorsIterator
     *          the iterator of colors to fill the buttons
     */
    ColorValuesIterator getColorIterator();

    /**
     * Get the type of the current question.
     * 
     * @return question
     *          the current question
     */
    QuestionType getCurrentQuestion();

    /**
     * Set the next question.
     * 
     * @return question
     *          the next question set
     */
    QuestionType nextQuestion();
}

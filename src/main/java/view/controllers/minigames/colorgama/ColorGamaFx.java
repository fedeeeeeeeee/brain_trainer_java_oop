package view.controllers.minigames.colorgama;

import org.apache.commons.lang3.tuple.Triple;

import model.minigames.colorgama.ComputeColor;

/**
 * The view interface of ColorGama minigame.
 *
 */
public interface ColorGamaFx {

    /**
     * Switch to the end scene of the game.
     * 
     * @param finalScore
     *          the final score obtained
     */
    void endGame(int finalScore);

    /**
     * Fill a grid with buttons.
     *
     * @param size
     *          the grid size
     */
    void drawGrid(int size);

    /**
     * Show the next level.
     * 
     * @param computeColor
     *          the colors of buttons
     */
    void showNext(ComputeColor computeColor);

    /**
     * Show the tick image.
     */
    void rightAnswer();

    /**
     * Show the cross image. 
     */
    void wrongAnswer();

    /**
     * 
     * @param currentQuestion
     */
    void showNextQuestion(String currentQuestion);

    /**
     * 
     * @param hue
     * @param saturation
     * @param brightness
     */
    void showQuestionColor(Integer hue, Double saturation, Double brightness);

    /**
     * 
     */
    void hideQuestionColor();

    /**
     * 
     * @param index
     * @param triple
     */
    void setRightColor(int index, Triple<Integer, Double, Double> triple);

    /**
     * 
     * @param seconds
     */
    void startTimer(int seconds);
}

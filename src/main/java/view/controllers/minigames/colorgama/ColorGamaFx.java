package view.controllers.minigames.colorgama;

import org.apache.commons.lang3.tuple.Triple;
import model.minigames.colorgama.ComputeColor;

/**
 * The view interface of ColorGama minigame.
 *
 */
public interface ColorGamaFx {

    /**
     * Fill a grid with buttons.
     *
     * @param size
     *          the grid size
     */
    void initGrid(int size);

    /**
     * Render the next level.
     * 
     * @param computeColor
     *          the colors of buttons
     *
     * @param questionSentence
     *          the sentence of the question to show
     */
    void renderNext(ComputeColor computeColor, String questionSentence);
 
    /**
     * Set the right color to the button.
     * 
     * @param index
     *          the button index
     *
     * @param colorValues
     *          the hsb values of the color
     */
    void setRightColor(int index, Triple<Integer, Double, Double> colorValues);
 
    /**
     * Shows the color indicated in the question. 
     * 
     * @param hue
     *          the hue value
     *
     * @param saturation
     *          the saturation value
     *
     * @param brightness
     *          the brightness value
     */
    void showQuestionColor(Integer hue, Double saturation, Double brightness);

    /**
     * Hide the color indicated in the question. 
     */
    void hideQuestionColor();

    /**
     * Show the tick image.
     */
    void rightAnswer();

    /**
     * Show the cross image. 
     */
    void wrongAnswer();

}

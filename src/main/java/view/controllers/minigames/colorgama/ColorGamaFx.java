package view.controllers.minigames.colorgama;

import model.minigames.colorgama.ColorValuesIterator;

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
     * @param colorIterator
     *          the colors of buttons
     *
     * @param questionSentence
     *          the sentence of the question to show
     */
    void renderNext(ColorValuesIterator colorIterator, String questionSentence);
 
    /**
     * Shows the color indicated in the question. 
     * 
     * @param colorIterator
     *          the colors of buttons
     */
    void showQuestionColor(ColorValuesIterator colorIterator);

    /**
     * Hide the color indicated in the question. 
     */
    void hideQuestionColor();

    /**
     * Show the image.
     *
     * @param check
     *          check for right or wrong answer
     */
    void showImage(boolean check);

}

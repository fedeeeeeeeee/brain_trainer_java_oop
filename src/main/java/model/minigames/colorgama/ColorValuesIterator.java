package model.minigames.colorgama;

import java.util.Iterator;

/**
 * This interface represents aspects of the color values of the minigame.
 *
 */
public interface ColorValuesIterator extends Iterator<ColorValues<?>> {

    /**
     * Get a index of the right color.
     * 
     * @return index
     *          right color's index
     */
    int getRightColorIndex();

    /**
     * Get the right color values.
     * 
     * @return values
     *          the component of the right color
     */
    ColorValues<?> getRightColor();

    /**
     * Reset all values according to the question.
     * 
     * @param question
     *          the current question.
     */
    void resetValues(QuestionType question);
}

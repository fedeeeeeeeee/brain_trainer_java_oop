package model.minigames.colorgama;

/**
 * This interface represents the color values.
 *
 * @param <X>
 *          the type to represent values of the color.
 */
public interface ColorValues<X> {

    /**
     * Get the value of a color.
     * 
     * @return value
     *          the color value
     */
    X getValue();

    /**
     * Get the String representation of the color values.
     * 
     * @return colorString
     *          the color in String
     */
    String getColorString();
}

package model.minigames.colorgama;

/**
 * 
 * An interface that models a Triple composed by three generic Objects.
 *
 * @param <X> the first component
 * @param <Y> the second component
 * @param <Z> the third component
 * 
 */
public interface Triple<X, Y, Z> {

    /**
     * Getter for the first component.
     * 
     * @return x 
     *          the first value
     */
    X getX();

    /**
     * Getter for the second component.
     * 
     * @return x 
     *          the second value
     */
    Y getY();

    /**
     * Getter for the third component.
     * 
     * @return x 
     *          the third value
     */
    Z getZ();
}

package model.minigames.sizeCount;

import java.util.List;

/**
 * 
 * A interface to compute dividers of a number.
 *
 */
public interface Dividers {

    /**
     * Get the dividers of a number.
     * 
     * @param number the number whose dividers you want to know
     * 
     * @return the list of the dividers of the number specify
     */
    List<Integer> getDividers(Integer number);

}

package model.minigames.perilouspath;

import model.DifficultyLevel;

public interface DifficultyBuilder<X> {
    
    /**
     * Initialize the current difficulty level.
     * 
     * @param currentDifficultyLevel
     *              the current difficulty level
     * @return a generic difficulty builder
     */
    X setDifficultyLevel(DifficultyLevel currentDifficultyLevel);
    
    /**
     * Modify the default size in a specific difficulty.
     * 
     * @param size
     *          the dimension's size
     * @return a generic difficulty builder
     */
    X setSize(int size);

}

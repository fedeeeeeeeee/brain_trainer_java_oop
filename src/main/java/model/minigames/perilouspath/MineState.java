package model.minigames.perilouspath;

/**
 * Represent the state of a mine.
 */
public enum MineState {
    
    /**
     * The mine is not detonated.
     */
    UNEXPLODED,
    
    /**
     * The mine is exploded.
     */
    EXPLODED;
    
    /**
     * Check if the user hits the mine.
     * 
     * @return true if the mine is exploded, false otherwise
     */
    public boolean isExploded() {
        return this == UNEXPLODED ? false : true;
    }
}

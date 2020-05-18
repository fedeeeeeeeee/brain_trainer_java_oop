package model.minigames.perilouspath;

/**
 * Represents the Perilous Path Model.
 */
public interface PerilousPathModel {

    /**
     * Get the size of the current level.
     * 
     * @return the size of the current level
     */
    int getSize();

    /**
     * Add point when user finds the right path.
     */
    void addPoint();

    /**
     * Get the final score.
     * 
     * @return the final score
     */
    int getFinalScore(); 
}

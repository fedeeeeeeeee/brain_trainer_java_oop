package model.minigames.perilousPath;

/**
 * Represents the Perilous Path Model.
 */
public interface PerilousPathModel {

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

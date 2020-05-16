package controller.minigames.perilousPath;

/**
 * Represents the Perilous Path Controller.
 */
public interface PerilousPathController {

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

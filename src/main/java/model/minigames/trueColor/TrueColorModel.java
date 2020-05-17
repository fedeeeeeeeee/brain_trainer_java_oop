package model.minigames.trueColor;

/**
 * The model interface of TrueColor minigame.
 *
 */
public interface TrueColorModel {

	/**
     * Add points when the user gave the right answer.
     */
    void addPoint();

    /**
     * Get the final score.
     * 
     * @return score
     */
    int getFinalScore();
    
}

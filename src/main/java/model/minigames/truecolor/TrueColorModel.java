package model.minigames.truecolor;

import java.util.Map;

import utility.Pair;

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
    
    /**
	 * Get the a Map of random color.
	 * 
	 * @return Map<String, Pair<String, String>> of random color
	 */
	Map<String, Pair<String, String>> getColorMap();

	/**
     * Reload the map containing the random color for the button.
     * 
     */
	void reloadRandomColorMap();
	
	/**
     * Check if is the right answer.
     * 
     * @return true if the meaning and the ink match
     */
	boolean matchingMeaningAndInk(String selectedAnswer);
    
}

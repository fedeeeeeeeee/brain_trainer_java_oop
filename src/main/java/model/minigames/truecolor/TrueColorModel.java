package model.minigames.truecolor;

import java.util.List;
import java.util.Map;

import utility.Pair;

/**
 * The model interface of TrueColor minigame.
 *
 */
public interface TrueColorModel {

	/**
	 * Reload the map containing the random color for the button.
	 * 
	 */
	void reloadRandomColorMap();

	/**
	 * Check if is the right answer.
	 * 
	 * @return {@link boolean} 
	 *           true if the meaning and the ink match
	 */
	boolean matchingMeaningAndInk(String selectedAnswer);

	/**
	 * Get the a Map of random color.
	 * 
	 * @return Map<String, Pair<String, String>> of random color
	 */
	Map<String, List<Pair<Colors, Colors>>> getRandomColorMap();

	/**
	 * Get the a boolean in order to call a specific method
	 * 
	 * @return a random {@link boolean} value
	 */
	Boolean getStatusMethod();

	/**
	 * Add points when the user gave the right answer.
	 * 
	 */
	void addPoint();

	/**
	 * Get the final score.
	 * 
	 * @return score
	 */
	int getFinalScore();

	/**
	 * 
	 * Return minigame's duration.
	 * 
	 * @return minigame's duration in seconds
	 */
	int getSecondsGame();
}

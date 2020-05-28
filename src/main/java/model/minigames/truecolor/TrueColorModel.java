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
	List<Pair<Colors, Colors>> getMeaningColorBtnList();

	List<Pair<Colors, Colors>> getTrueColorBtnList();

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

	public Integer getNumberTrueColorButton();

	public Integer getNumberMeaningColorButton();

	public Boolean getStatusMethod();

	/**
	 * 
	 * Return minigame's duration.
	 * 
	 * @return minigame's duration in seconds
	 */
	int getSecondsGame();
}

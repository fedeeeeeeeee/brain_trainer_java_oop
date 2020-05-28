package view.controllers.minigames.truecolor;

import java.util.List;
import java.util.Map;

import model.minigames.truecolor.Colors;
import utility.Pair;

public interface TrueColorFx {

	/**
	 * Reload the components of the scene.
	 * 
	 */
	void next();

	/**
	 * Associate a random color from map with text of the button.
	 * 
	 * @param finalScore
	 */
	void setButtons(List<Pair<Colors, Colors>> randomColor, List<Pair<Colors, Colors>> randomColor2);
	
	void setNumberBtn(Integer meaningColor, Integer trueColor);

	/**
	 * Associate a random color from the map with background button for three times.
	 * 
	 * @param randomColor map of buttons name and random colors
	 */
	void alternativeSetButton(List<Pair<Colors, Colors>> randomColor);

	/**
	 * Show the wrong answer coloring the button's border
	 * 
	 */
	void showWrongAnswer();

	/**
	 * Show the correct answer coloring the button's border
	 * 
	 */
	void showCorrectAnswer();

	void stopTimer();

}

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
	 * Set a random color and a random textColor to buttons.
	 * 
	 * @param colorMap
	 * 					map with lists of Colors pair
	 */
	void setButtons(Map<String, List<Pair<Colors, Colors>>> colorMap);
	
	/**
	 * Set the number of button.
	 * 
	 * @param meaningColor
	 * 						the buttons that hold the meaning of the text
	 * @param trueColor
	 * 						the buttons that hold true color of the others button meaning 
	 */
	void setNumberBtn(Integer meaningColor, Integer trueColor);

	/**
	 * Set a random color to the buttons background.
	 * 
	 * @param randomColor
	 * 					 list of random color belonging to true color list
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


}

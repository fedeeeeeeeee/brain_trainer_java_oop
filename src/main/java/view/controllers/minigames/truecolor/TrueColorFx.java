package view.controllers.minigames.truecolor;

import java.util.Map;

import utility.Pair;

public interface TrueColorFx {

	/**
     * Reload the components of the scene.
     * 
     */
	public void next();
	
	/**
     * Associate a random color from map with text of the button.
     * 
     * @param finalScore
     */
	public void setButton(Map<String, Pair<String, String>> randomColor);
	
	/**
     * Associate a random color from map with text of the button for three times.
     * 
     * @param randomColor map of buttons name and random colors
     */
	public void setThreeButton(Map<String, Pair<String, String>> randomColor);
	
	/**
     * Associate a random color from the map with background button for three times.
     * 
     * @param randomColor map of buttons name and random colors
     */
	public void alternativeSetThreeButton(Map<String, Pair<String, String>> randomColor);
	
	/**
     * Show the wrong answer coloring the button's border
     * 
     */
	public void showWrongAnswer();
		
	/**
     * Show the correct answer coloring the button's border
     * 
     */
	public void showCorrectAnswer();
	
	
}

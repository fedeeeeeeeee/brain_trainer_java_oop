package controller.minigames.truecolor;

import controller.minigames.MiniGameController;


public interface TrueColorController extends MiniGameController {

	
	void startGame();
	
	/**
	 * 
     * Reload the map containing the random color for the button 
     * 
     */
	void refresh();
	
	/**
     * Check if is the right answer.
     * 
     * @return true if the meaning and the ink match
     */
	void check(String selectedAnswer);
	
	void stopTimer();
	

	void startTimer();
	
}

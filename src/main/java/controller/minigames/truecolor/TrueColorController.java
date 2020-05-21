package controller.minigames.truecolor;

public interface TrueColorController {

	/**
	 * The time is expired.
	 */
	void timeExpired();
	
	
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
	
}

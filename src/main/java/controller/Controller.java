package controller;

import model.UserPlayer;
import view.TrainingArea;
import view.View;

/**
 * The controller interface of the whole game.
 *
 */
public interface Controller {
	
	/**
	 * Set the first scene to show
	 *
	 * @param view
	 * 			  the scene to show
	 */
	void initializeView(View view);
	
	/**
	 * Set the logged in user as the player of the actual game session
	 * 
	 * @param player
	 * 				the current player 
	 */
	void initializePlayer(UserPlayer player);
	
	
	/**
	 * Set the selected training area 
	 * 
	 * @param area
	 * 			  the selected {@link TrainingArea}  
	 */
	void setArea(TrainingArea area);
	
	
	/**
	 * Getter for the selected training area
	 * 
	 * @return area
	 * 			  the selected {@link TrainingArea}  
	 */
	TrainingArea getArea();
}

package model;

import view.TrainingArea;

public interface Model {
	
	/**
	 * Set the player of the game
	 * 
	 * @param player
	 */
	void setUserPlayer(UserPlayer player);

	void setArea(TrainingArea area);
	
	TrainingArea getArea();
	
}

package model;

public interface Model {
	
	/**
	 * Set the player of the game
	 * 
	 * @param player
	 */
	void setUserPlayer(UserPlayer player);

	void setArea(String area);
	
	String getArea();
	
}

package score;

/**
 * 
 * This interface models the score obtained at the end of the game 
 * 
 */
public interface Score {
	
	/**
	 * save the score of the user based on the zone
	 * 
	 * @param user 
	 * @param zone of the minigame
	 */
//	void saveScore(User user, Zone zone);
	
	/**
	 * update the score of the minigame
	 * 
	 * @param point
	 */
	void updateScore(int point);
	
	/**
	 * get total point of the minigame
	 * 
	 * @return the final score 
	 */
	int getValue();
}

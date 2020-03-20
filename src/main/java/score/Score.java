package score;

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
}

package model.score;

/**
 * This interface models points achieved by right answers
 * 
 *
 */
public interface ScoreModel {
	
	/**
	 * add points when the user gave the right answer 
	 */
	void addPoint();
	
	/**
	 * get the score of the minigame played 
	 * 
	 * @return score 
	 */
	int getScore();
}

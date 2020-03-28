package model;

public class ExampleMiniGameModel {
	
	private static final int BASE_POINT = 2;
	
	private DifficultyLevel difficulty;
	
	public ExampleMiniGameModel(DifficultyLevel difficulty) {
		this.difficulty = difficulty;
	}
	
	public boolean checkAnswer() {
		return true;
	}
	
	public DifficultyLevel getDifficulty() {
		return this.difficulty;
	}
	
	public int getBasePoint() {
		return this.BASE_POINT;
	}
	

}

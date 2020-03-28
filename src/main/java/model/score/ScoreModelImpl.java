package model.score;

import model.DifficultyLevel;

public class ScoreModelImpl implements ScoreModel {
	
	private static final int MULTIPLICATIVE_INCREMENT = 2;
	
	private final DifficultyLevel difficulty;
	private final int basePoint;
	private int increment;
	private int score;
	private boolean isFinish;

	public ScoreModelImpl(DifficultyLevel difficulty, int basePoint) {
		this.checkDifficultyNotNull(difficulty);
		this.difficulty = difficulty;
		this.basePoint = basePoint;	
		this.score = 0;
		this.isFinish = false;
		this.initializeIncrement();
	}

	private void initializeIncrement() {
		this.increment = (this.difficulty.ordinal()+this.basePoint)*MULTIPLICATIVE_INCREMENT;
	}

	private void check(boolean b) {
		if(b) {
			throw new IllegalStateException();
		}		
	}
	
	private void checkDifficultyNotNull(DifficultyLevel difficulty) {
		if (difficulty.equals(null)) {
			throw new NullPointerException();
		}
	}
	
	@Override
	public void addPoint() {
		this.check(this.isFinish);
		this.score = this.score + this.increment;
	}
	
	@Override
	public int getScore() {
		this.check(this.isFinish);
		this.isFinish = true;
		return this.score;
	}
}

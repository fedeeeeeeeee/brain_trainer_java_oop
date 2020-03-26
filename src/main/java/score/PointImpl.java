package score;

import model.DifficultyLevel;

public class PointImpl implements Point {
	
	private static final int MULTIPLICATIVE_INCREMENT = 2;
	
	private final DifficultyLevel difficulty;
	private final int basePoint;
	private int increment;
	private final Score score;
	private boolean isFinish;

	public PointImpl(DifficultyLevel difficulty, int basePoint) {
		this.checkDifficultyNotNull(difficulty);
		this.difficulty = difficulty;
		this.basePoint = basePoint;	
		this.score = new ScoreImpl();
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
		this.score.updateScore(this.increment);
	}
	
	@Override
	public Score getScore() {
		this.check(this.isFinish);
		this.isFinish = true;
		return this.score;
	}
}

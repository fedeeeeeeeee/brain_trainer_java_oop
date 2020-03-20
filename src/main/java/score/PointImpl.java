package score;

import model.DifficultyLevel;

public class PointImpl implements Point {
	
	private static final int EASYPOINT = 5;
	private static final int NORMALPOINT = 10;
	private static final int HARDPOINT = 15;
	
	private final DifficultyLevel difficulty;
	private final int basePoint;
	private int increment;
	private final Score score;
	private boolean isFinish;

	public PointImpl(DifficultyLevel difficulty, int basePoint) {
		this.difficulty = difficulty;
		this.basePoint = basePoint;	
		this.score = new ScoreImpl();
		this.isFinish = false;
		this.initializeIncrement();
	}
	
	
	private void initializeIncrement() {
		switch(this.difficulty) {
		case EASY: 
			this.increment = EASYPOINT;
			break;
		case NORMAL: 
			this.increment = NORMALPOINT;
			break;
		case HARD: 
			this.increment = HARDPOINT;
			break;
		}
		
	}

	private void check(boolean b) {
		if(b) {
			throw new IllegalStateException();
		}		
	}
	
	@Override
	public void addPoint() {
		this.check(this.isFinish);
		this.score.updateScore(this.basePoint + this.increment);
	}



	@Override
	public int getScore() {
		this.check(this.isFinish);
		this.isFinish = true;
		return this.score.getFinalScore();
	}

}

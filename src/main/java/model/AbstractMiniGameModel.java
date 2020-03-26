package model;

import score.Point;
import score.PointImpl;
import score.Score;

public class AbstractMiniGameModel implements MiniGameModel {
	
	private Point point;
	
	public AbstractMiniGameModel(DifficultyLevel difficulty, int basePoint) {
		this.point = new PointImpl(difficulty, basePoint);
	}

	@Override
	public Score getFinalScore() {
		return this.point.getScore();
	}
}

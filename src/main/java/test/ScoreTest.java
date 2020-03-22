package test;

import model.DifficultyLevel;
import org.junit.jupiter.api.Test;
import score.Point;
import score.PointImpl;

import static org.junit.Assert.*;



class ScoreTest {
	private Point point;
	@Test
    public void testEasyBasicBehaviour() {
        this.point = new PointImpl(DifficultyLevel.EASY, 5);
        this.point.addPoint(); //10
		this.point.addPoint(); //20
		this.point.addPoint(); //30
		this.point.addPoint(); //40
		this.point.addPoint(); //50
		this.point.addPoint(); //60
		assertEquals(60, this.point.getScore());
	}
	@Test
	public void testEasyCheckFinishBehaviour() {
		this.point = new PointImpl(DifficultyLevel.EASY, 5);
		this.point.addPoint(); //10
		this.point.addPoint(); //20
		this.point.getScore(); //finish
		this.point.addPoint(); //IllegalStateException
	}

}

package test;

import model.DifficultyLevel;
import score.Point;
import score.PointImpl;
import org.junit.jupiter.api.Test;
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
    public void testNormalBasicBehaviour() {
        this.point = new PointImpl(DifficultyLevel.NORMAL, 10);
        this.point.addPoint(); //20
		this.point.addPoint(); //40
		this.point.addPoint(); //60
		this.point.addPoint(); //80
		this.point.addPoint(); //100
		this.point.addPoint(); //120
		assertEquals(120, this.point.getScore());
	}
	
	@Test
    public void testHardBasicBehaviour() {
        this.point = new PointImpl(DifficultyLevel.HARD, 15);
        this.point.addPoint(); //30
		this.point.addPoint(); //60
		this.point.addPoint(); //90
		this.point.addPoint(); //120
		this.point.addPoint(); //150
		this.point.addPoint(); //180
		assertEquals(180, this.point.getScore());
	}
	
	@Test
	public void testCheckFinishBehaviour() throws IllegalStateException {
		try {
			this.point = new PointImpl(DifficultyLevel.EASY, 5);
			this.point.addPoint(); //10
			this.point.addPoint(); //20
			assertEquals(this.point.getScore(), 20);
			this.point.addPoint(); //IllegalStateException
			assertEquals(this.point.getScore(), 20);
		    fail("Expected an IllegalStateException to be thrown");
		  } catch (IllegalStateException illegalStateException) { }
	}
	
	@Test
	public void testCheckNullBehaviour() throws NullPointerException {
		try {
			this.point = new PointImpl(null, 5);
		    fail("Expected an NullPointerException to be thrown");
		  } catch (NullPointerException NullPointerException) { }
	}
}

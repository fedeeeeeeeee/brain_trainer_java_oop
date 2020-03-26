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
        this.point = new PointImpl(DifficultyLevel.EASY, 5); //(0+5)*2
        this.point.addPoint(); //10
		this.point.addPoint(); //20
		this.point.addPoint(); //30
		this.point.addPoint(); //40
		this.point.addPoint(); //50
		this.point.addPoint(); //60
		assertEquals(60, this.point.getScore().getValue());
	}
	
	@Test
    public void testNormalBasicBehaviour() {
        this.point = new PointImpl(DifficultyLevel.NORMAL, 10); // (1+10)*2
        this.point.addPoint(); //22
		this.point.addPoint(); //44
		this.point.addPoint(); //66
		this.point.addPoint(); //88
		this.point.addPoint(); //110
		this.point.addPoint(); //132
		assertEquals(132, this.point.getScore().getValue());
	}
	
	@Test
    public void testHardBasicBehaviour() {
        this.point = new PointImpl(DifficultyLevel.HARD, 15); // (2+15)*2
        this.point.addPoint(); //34
		this.point.addPoint(); //68
		this.point.addPoint(); //102
		this.point.addPoint(); //136
		this.point.addPoint(); //170
		this.point.addPoint(); //204
		assertEquals(204, this.point.getScore().getValue());
	}
	
	@Test
	public void testCheckFinishBehaviour() throws IllegalStateException {
		try {
			this.point = new PointImpl(DifficultyLevel.EASY, 5);
			this.point.addPoint(); //10
			this.point.addPoint(); //20
			assertEquals(20, this.point.getScore().getValue());
			this.point.addPoint(); //IllegalStateException
			assertEquals(20, this.point.getScore().getValue());
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

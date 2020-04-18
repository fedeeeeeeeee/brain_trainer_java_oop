package test;

import model.DifficultyLevel;
import model.score.ScoreModel;
import model.score.ScoreModelImpl;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class ScoreTest {
	
	private ScoreModel point;
	
	@Test
    public void testEasyBasicBehavior() {
        this.point = new ScoreModelImpl(DifficultyLevel.EASY, 5); //(0+5)*2
        this.point.addPoint(); //10
		this.point.addPoint(); //20
		this.point.addPoint(); //30
		this.point.addPoint(); //40
		this.point.addPoint(); //50
		this.point.addPoint(); //60
		assertEquals(60, this.point.getScore());
	}
	
	@Test
    public void testNormalBasicBehavior() {
        this.point = new ScoreModelImpl(DifficultyLevel.NORMAL, 10); // (1+10)*2
        this.point.addPoint(); //22
		this.point.addPoint(); //44
		this.point.addPoint(); //66
		this.point.addPoint(); //88
		this.point.addPoint(); //110
		this.point.addPoint(); //132
		assertEquals(132, this.point.getScore());
	}
	
	@Test
    public void testHardBasicBehavior() {
        this.point = new ScoreModelImpl(DifficultyLevel.HARD, 15); // (2+15)*2
        this.point.addPoint(); //34
		this.point.addPoint(); //68
		this.point.addPoint(); //102
		this.point.addPoint(); //136
		this.point.addPoint(); //170
		this.point.addPoint(); //204
		assertEquals(204, this.point.getScore());
	}
	
	@Test
	public void testCheckFinishBehavior() throws IllegalStateException {
		try {
			this.point = new ScoreModelImpl(DifficultyLevel.EASY, 5);
			this.point.addPoint(); //10
			this.point.addPoint(); //20
			assertEquals(20, this.point.getScore());
			this.point.addPoint(); //IllegalStateException
			assertEquals(20, this.point.getScore());
		    fail("Expected an IllegalStateException to be thrown");
		  } catch (IllegalStateException illegalStateException) { }
	}
	
	@Test
	public void testCheckNullBehavior() throws NullPointerException {
		try {
			this.point = new ScoreModelImpl(null, 5);
		    fail("Expected an NullPointerException to be thrown");
		  } catch (NullPointerException NullPointerException) { }
	}
}

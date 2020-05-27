package test.minigames.oneway;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import model.DifficultyLevel;
import model.minigames.oneWay.OneWayModel;
import model.minigames.oneWay.OneWayModelImpl;

/**
 * Class to test if {@link OneWayModel} works correctly.
 *
 */
public class OneWayTest {
    private static final int EASY_LEVEL_ARROW = 3;
    private static final int NORMAL_LEVEL_ARROW = 4;
    private static final int HARD_LEVEL_ARROW = 5;
    private static final int EASY_LEVEL_SEC = 45;
    private static final int NORMAL_LEVEL_SEC = 30;
    private static final int HARD_LEVEL_SEC = 40;
    
    private OneWayModel model;

    @Test
    public void easyLevelTest() {
        this.model = new OneWayModelImpl(DifficultyLevel.EASY);
        this.model.initializeOneWay();
        assertEquals(EASY_LEVEL_ARROW, this.model.getArrowsCount());
        assertEquals(EASY_LEVEL_SEC, this.model.getSeconds());
    }

    @Test
    public void normalLevelyTest() {
        this.model = new OneWayModelImpl(DifficultyLevel.NORMAL);
        this.model.initializeOneWay();
        assertEquals(NORMAL_LEVEL_ARROW, this.model.getArrowsCount());
        assertEquals(NORMAL_LEVEL_SEC, this.model.getSeconds());
    }

    @Test
    public void hardLevelTest() {
        this.model = new OneWayModelImpl(DifficultyLevel.HARD);
        this.model.initializeOneWay();
        assertEquals(HARD_LEVEL_ARROW, this.model.getArrowsCount());
        assertEquals(HARD_LEVEL_SEC, this.model.getSeconds());
    }

    /**
     * Test index bounds on initial and final positions
     * 
     */
    @Test
    public void testInitialAndFinalPosValidity() {
        OneWayModel model = new OneWayModelImpl(DifficultyLevel.EASY);
        model.initializeOneWay();

        assertTrue(model.getInitialPosition().getX() < model.getSize());
        assertTrue(model.getInitialPosition().getY() < model.getSize());
        assertTrue(model.getInitialPosition().getX() >= 0);
        assertTrue(model.getInitialPosition().getY() >= 0);

        assertTrue(model.getFinalPosition().getX() < model.getSize());
        assertTrue(model.getFinalPosition().getY() < model.getSize());
        assertTrue(model.getFinalPosition().getX() >= 0);
        assertTrue(model.getFinalPosition().getY() >= 0);
    }
    
    @Test
    public void testPositions() {
        OneWayModel model = new OneWayModelImpl(DifficultyLevel.EASY);
        model.initializeOneWay();
        assertFalse(model.getInitialPosition().getX() == model.getFinalPosition().getX() && model.getInitialPosition().getY() == model.getFinalPosition().getY());
    }
    
}

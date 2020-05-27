package test.minigames.oneway;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    private OneWayModel model;

    @Test
    public void easyLevelTest() {
        this.model = new OneWayModelImpl(DifficultyLevel.EASY);
        this.model.initializeOneWay();
        assertEquals(EASY_LEVEL_ARROW, this.model.getArrowsCount());
    }

    @Test
    public void normalLevelyTest() {
        this.model = new OneWayModelImpl(DifficultyLevel.NORMAL);
        this.model.initializeOneWay();
        assertEquals(NORMAL_LEVEL_ARROW, this.model.getArrowsCount());
    }

    @Test
    public void hardLevelTest() {
        this.model = new OneWayModelImpl(DifficultyLevel.HARD);
        this.model.initializeOneWay();
        assertEquals(HARD_LEVEL_ARROW, this.model.getArrowsCount());
    }

    /**
     * Test index bounds on initial and final positions
     * 
     */
    @Test
    public void testInitialAndFinalPosValidity() {
        OneWayModel model2 = new OneWayModelImpl(DifficultyLevel.EASY);
        model2.initializeOneWay();

        assertTrue(model2.getInitialPosition().getX() < model2.getSize());
        assertTrue(model2.getInitialPosition().getY() < model2.getSize());
        assertTrue(model2.getInitialPosition().getX() >= 0);
        assertTrue(model2.getInitialPosition().getY() >= 0);

        assertTrue(model2.getFinalPosition().getX() < model2.getSize());
        assertTrue(model2.getFinalPosition().getY() < model2.getSize());
        assertTrue(model2.getFinalPosition().getX() >= 0);
        assertTrue(model2.getFinalPosition().getY() >= 0);
    }
}

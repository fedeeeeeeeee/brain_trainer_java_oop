package test.minigames.perilouspath;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.DifficultyLevel;
import model.minigames.perilouspath.Difficulty;
import model.minigames.perilouspath.DifficultyImpl;

/**
 * Class to test if {@link Difficulty} works correctly.
 */
public class DifficultyTest {

    private static final int EASY_SIZE = 5;
    private static final int EASY_NUM_MINES = 11;
    private static final int NORMAL_SIZE = 6;
    private static final int NORMAL_NUM_MINES = 22;
    private static final int HARD_SIZE = 7;
    private static final int HARD_NUM_MINES = 33;

    private Difficulty difficulty;

    /**
     * Test the easy difficulty.
     */
    @Test
    public void easyDifficultyTest() {
        this.difficulty = new DifficultyImpl(DifficultyLevel.EASY);
        assertEquals(EASY_SIZE, this.difficulty.getSize());
        assertEquals(EASY_NUM_MINES, this.difficulty.getNumMines());
    }

    /**
     * Test the normal difficulty.
     */
    @Test
    public void normalDifficultyTest() {
        this.difficulty = new DifficultyImpl(DifficultyLevel.NORMAL);
        assertEquals(NORMAL_SIZE, this.difficulty.getSize());
        assertEquals(NORMAL_NUM_MINES, this.difficulty.getNumMines());
    }

    /**
     * Test the hard difficulty.
     */
    @Test
    public void hardDifficultyTest() {
        this.difficulty = new DifficultyImpl(DifficultyLevel.HARD);
        assertEquals(HARD_SIZE, this.difficulty.getSize());
        assertEquals(HARD_NUM_MINES, this.difficulty.getNumMines());
    }
}

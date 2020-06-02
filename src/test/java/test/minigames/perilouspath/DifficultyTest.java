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
    private static final int EASY_NUM_MINES = 10;
    private static final int NORMAL_SIZE = 6;
    private static final int NORMAL_NUM_MINES = 20;
    private static final int HARD_SIZE = 7;
    private static final int HARD_NUM_MINES = 30;

    private Difficulty difficulty;

    private Difficulty difficulty(final DifficultyLevel difficulty) {
        return new DifficultyImpl(difficulty);
    }

    /**
     * Test the easy difficulty.
     */
    @Test
    public void easyDifficultyTest() {
        this.difficulty = this.difficulty(DifficultyLevel.EASY);
        assertEquals(EASY_SIZE, this.difficulty.getSize());
        assertEquals(EASY_NUM_MINES, this.difficulty.getNumMines());
    }

    /**
     * Test the normal difficulty.
     */
    @Test
    public void normalDifficultyTest() {
        this.difficulty = this.difficulty(DifficultyLevel.NORMAL);
        assertEquals(NORMAL_SIZE, this.difficulty.getSize());
        assertEquals(NORMAL_NUM_MINES, this.difficulty.getNumMines());
    }

    /**
     * Test the hard difficulty.
     */
    @Test
    public void hardDifficultyTest() {
        this.difficulty = this.difficulty(DifficultyLevel.HARD);
        assertEquals(HARD_SIZE, this.difficulty.getSize());
        assertEquals(HARD_NUM_MINES, this.difficulty.getNumMines());
    }
}

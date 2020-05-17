package test.minigames.perilousPath;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.DifficultyLevel;
import model.minigames.perilousPath.Difficulty;
import model.minigames.perilousPath.DifficultyImpl;

/**
 * Class to test if {@link Difficulty} works correctly.
 */
public class DifficultyTest {

    private Difficulty difficulty;

    /**
     * Test the easy difficulty.
     */
    @Test
    public void easyDifficultyTest() {
        this.difficulty = new DifficultyImpl(DifficultyLevel.EASY);
        assertEquals(5, this.difficulty.getSize());
        assertEquals(11, this.difficulty.getNumMines());
    }

    /**
     * Test the normal difficulty.
     */
    @Test
    public void normalDifficultyTest() {
        this.difficulty = new DifficultyImpl(DifficultyLevel.NORMAL);
        assertEquals(6, this.difficulty.getSize());
        assertEquals(22, this.difficulty.getNumMines());
    }

    /**
     * Test the hard difficulty.
     */
    @Test
    public void hardDifficultyTest() {
        this.difficulty = new DifficultyImpl(DifficultyLevel.HARD);
        assertEquals(7, this.difficulty.getSize());
        assertEquals(33, this.difficulty.getNumMines());
    }
}

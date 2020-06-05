package test.minigames.perilouspath;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import model.DifficultyLevel;
import model.minigames.perilouspath.PerilousPathDifficulty;
import model.minigames.perilouspath.PerilousPathDifficultyBuilderImpl;
import model.minigames.perilouspath.PathGameFactory;
import model.minigames.perilouspath.PathGameFactoryImpl;
import model.minigames.perilouspath.PathGameImpl;
import utility.Pair;

/**
 * Class to test if {@link PathGame} works correctly.
 */
public class PathGameTest {

    private LinkedList<Pair<Integer, Integer>> path; //NOPMD

    private PerilousPathDifficulty difficulty(final DifficultyLevel difficulty) {
        System.out.println(difficulty);
        System.out.println(new PerilousPathDifficultyBuilderImpl().setDifficultyLevel(difficulty).build());
        return new PerilousPathDifficultyBuilderImpl().setDifficultyLevel(difficulty).build();
    }

    /**
     * Test the length game's path.
     */
    @Test
    public void pathGameLengthTest() {
        final PerilousPathDifficulty difficulty = this.difficulty(DifficultyLevel.EASY);
        final PathGameFactory pathFactory = new PathGameFactoryImpl();
        this.path = pathFactory.createRandomDirectionPath(difficulty.getSize(), difficulty.getNumMines()).getPathList();
        assertTrue(this.path.size() <= (difficulty.getSize() * difficulty.getSize()) - difficulty.getNumMines());
    }

    /**
     * Test if the first element of the path is the start and the last is the finish.
     */
    @Test
    public void pathGameStartFinishTest() {
        final PerilousPathDifficulty difficulty = this.difficulty(DifficultyLevel.EASY);
        this.path = new PathGameImpl(difficulty.getSize(), difficulty.getNumMines(), new Pair<>(0, 0), new Pair<>(4, 4)).getPathList();
        assertEquals(new Pair<>(0, 0), this.path.getFirst());
        assertEquals(new Pair<>(4, 4), this.path.getLast());
    }

    /**
     * Test if throws NullPointerException if the objects passed are null.
     */
    @Test
    public void pathGameNullTest() {
        final PerilousPathDifficulty difficulty = this.difficulty(DifficultyLevel.EASY);
        assertThrows(NullPointerException.class, () -> new PathGameImpl(difficulty.getSize(), difficulty.getNumMines(), null, null));
    }

    /**
     * Test if throws IllegalStateException if the size and the number of mines are equals to zero.
     */
    @Test
    public void pathGameZeroTest() {
        assertThrows(IllegalStateException.class, () -> new PathGameImpl(0, 0, new Pair<>(0, 0), new Pair<>(4, 4)));
    }
}

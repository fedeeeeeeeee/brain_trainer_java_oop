package model.minigames.perilousPath;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

import model.DifficultyLevel;
import utility.Pair;

/**
 * Implements {@link Difficulty}.
 */
public class DifficultyImpl implements Difficulty {

    /**
     * The initial size.
     */
    private static final int SIZE = 5;

    /**
     * The initial amount of mines.
     */
    private static final int NUM_MINES = 11;

    private Map<DifficultyLevel, Pair<Integer, Integer>> difficulty;
    private DifficultyLevel currentDifficultyLevel;

    /**
     * Constructor of {@link Difficulty}.
     * 
     * @param difficultyLevel
     *                       the current difficulty level
     */
    public DifficultyImpl(final DifficultyLevel difficultyLevel) {
        this.difficulty = new EnumMap<>(DifficultyLevel.class);
        this.difficulty = Arrays.asList(DifficultyLevel.values())
                                .stream()
                                .collect(Collectors.toMap(k -> k, k -> new Pair<>(SIZE + this.increment(k), NUM_MINES * this.increment(k) + NUM_MINES)));
        this.currentDifficultyLevel = difficultyLevel;
    }

    private int increment(final DifficultyLevel difficultyLevel) {
        return DifficultyLevel.valueOf(difficultyLevel.toString()).ordinal();
    }

    private Pair<Integer, Integer> getValue() {
        return this.difficulty.get(currentDifficultyLevel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return this.getValue().getX();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNumMines() {
        return this.getValue().getY();
    }
}

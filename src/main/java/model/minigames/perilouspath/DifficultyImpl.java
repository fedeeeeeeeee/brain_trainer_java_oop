package model.minigames.perilouspath;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import model.DifficultyLevel;
import utility.Pair;

/**
 * Implementation of {@link Difficulty}.
 */
public class DifficultyImpl implements Difficulty {

    /**
     * The initial size.
     */
    private static final int SIZE = 5;

    /**
     * The initial amount of mines.
     */
    private static final int NUM_MINES = 10;

    private final Map<DifficultyLevel, Pair<Integer, Integer>> difficulty;
    private final DifficultyLevel currentDifficultyLevel;

    /**
     * Constructor of {@link Difficulty}.
     * 
     * @param difficultyLevel
     *                       the current difficulty level
     */
    public DifficultyImpl(final DifficultyLevel difficultyLevel) {
        Objects.requireNonNull(difficultyLevel);
        this.difficulty = Arrays.asList(DifficultyLevel.values())
                                .stream()
                                .collect(Collectors.toMap(k -> k, k -> new Pair<>(SIZE + this.increment(k), NUM_MINES * this.increment(k) + NUM_MINES)));
        this.currentDifficultyLevel = difficultyLevel;
    }

    private int increment(final DifficultyLevel difficultyLevel) {
        Objects.requireNonNull(difficultyLevel);
        return DifficultyLevel.valueOf(difficultyLevel.toString().toUpperCase(Locale.getDefault())).ordinal();
    }

    private Pair<Integer, Integer> getValue(final DifficultyLevel difficultyLevel) {
        Objects.requireNonNull(difficultyLevel);
        return this.difficulty.get(difficultyLevel);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return this.getValue(this.currentDifficultyLevel).getX();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getNumMines() {
        return this.getValue(this.currentDifficultyLevel).getY();
    }
}

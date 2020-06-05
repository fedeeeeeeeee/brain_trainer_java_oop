package model.minigames.perilouspath;

import java.util.EnumMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

import model.DifficultyLevel;
import utility.Pair;

public class PerilousPathDifficultyBuilderImpl implements PerilousPathDifficultyBuilder {

    /**
     * The size's lower bound.
     */
    private static final int MINIMUM_SIZE = 4;

    /**
     * The initial size.
     */
    private static final int SIZE = 5;

    /**
     * The initial amount of mines.
     */
    private static final int NUM_MINES = 10;

    private final EnumMap<DifficultyLevel, Pair<Integer, Integer>> difficulty;
    private Optional<DifficultyLevel> currentDifficultyLevel;
    private boolean built;

    public PerilousPathDifficultyBuilderImpl() {
        this.difficulty = this.initDefaultDifficulty();
        this.built = false;
    }

    private int increment(final DifficultyLevel difficultyLevel) {
        Objects.requireNonNull(difficultyLevel);
        return DifficultyLevel.valueOf(difficultyLevel.toString().toUpperCase(Locale.getDefault())).ordinal();
    }

    private EnumMap<DifficultyLevel, Pair<Integer, Integer>> initDefaultDifficulty() {
        for (final DifficultyLevel d : DifficultyLevel.values()) {
            this.difficulty.put(d, new Pair<>(SIZE + this.increment(d), NUM_MINES * this.increment(d) + NUM_MINES));
        }
        return this.difficulty;
    }

    private static void check(final boolean b) {
        if (!b) {
            throw new IllegalStateException();
        }
    }

    private static void validity(final boolean b) {
        if (b) {
           throw new IllegalArgumentException();
        }
    }

    private static <X> Optional<X> reassignOptional(final Optional<X> opt, final X x) {
        check(!opt.isPresent());
        return Optional.of(x);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerilousPathDifficultyBuilder setDifficultyLevel(final DifficultyLevel currentDifficultyLevel) {
        check(!this.built);
        this.currentDifficultyLevel = reassignOptional(this.currentDifficultyLevel, currentDifficultyLevel);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerilousPathDifficultyBuilder setSize(final int size) {
        final int numMines = this.difficulty.get(this.currentDifficultyLevel.get()).getY();
        validity(size < MINIMUM_SIZE);
        this.difficulty.replace(this.currentDifficultyLevel.get(), new Pair<>(size, numMines));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerilousPathDifficultyBuilder setNumMines(final int numMines) {
        final int size = this.difficulty.get(this.currentDifficultyLevel.get()).getX();
        validity(numMines >= size * size);
        this.difficulty.replace(this.currentDifficultyLevel.get(), new Pair<>(size, numMines));
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PerilousPathDifficulty build() {
        check(!this.built);
        check(this.currentDifficultyLevel.isPresent());
        this.built = true;

        return new PerilousPathDifficulty() {

            private Pair<Integer, Integer> getValue(final DifficultyLevel difficultyLevel) {
                return difficulty.get(difficultyLevel);
            }

            @Override
            public int getSize() {
                return this.getValue(currentDifficultyLevel.get()).getX();
            }

            @Override
            public int getNumMines() {
                return this.getValue(currentDifficultyLevel.get()).getY();
            }

        };
    }
}

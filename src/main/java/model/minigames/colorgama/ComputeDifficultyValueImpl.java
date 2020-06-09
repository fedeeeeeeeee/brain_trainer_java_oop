package model.minigames.colorgama;

import java.util.Objects;
import java.util.function.BiFunction;

import model.DifficultyLevel;

/**
 * This class implements {@link ComputeDifficultyValue}.
 *
 */
public final class ComputeDifficultyValueImpl implements ComputeDifficultyValue {

    private static final String NULL_ARG = " passed is null";
    private static final int BASE = 4;
    private static final int OFFSET = 10;
    private static final int ORIGIN = 30;
    private static final int ORIGIN_VALUE = 20;
    private static final int BOUND = 100;
    private static final int BASE_SECONDS = 5;
    private static final int BASE_VALUE = -1;
    private final int gridSize;
    private final int valueRange;
    private final int hueRange;
    private final int seconds;
    private final int numColors;

    /**
     * Constructor of {@link ComputeDifficultyValue}.
     * 
     * @param difficulty
     *          the current difficulty level
     */
    public ComputeDifficultyValueImpl(final DifficultyLevel difficulty) {
        Objects.requireNonNull(difficulty, "DifficultyLevel" + NULL_ARG);
        final BiFunction<Integer, Integer, Integer> operation = (i1, i2) -> i1 * difficulty.ordinal() + i2;
        this.gridSize = operation.apply(BASE, BASE);
        this.seconds = operation.apply(BASE_SECONDS, ORIGIN);
        this.hueRange = operation.apply(BASE_VALUE, ORIGIN_VALUE);
        this.valueRange = operation.apply(BASE_VALUE, OFFSET);
        this.numColors = operation.apply(BASE, BASE);
    }

    @Override
    public int getGridSize() {
        return this.gridSize;
    }

    @Override
    public int getBasePoint() {
        return BASE;
    }

    @Override
    public int getNumColor() {
        return this.numColors;
    }

    @Override
    public int getRandomColorOrigin() {
        return ORIGIN;
    }

    @Override
    public int getRandomColorBound() {
        return BOUND - this.valueRange;
    }

    @Override
    public int getHueRange() {
        return this.hueRange;
    }

    @Override
    public int getValueRange() {
        return this.valueRange;
    }

    @Override
    public int getSeconds() {
        return this.seconds;
    }
}

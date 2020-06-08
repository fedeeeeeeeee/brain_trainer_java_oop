package model.minigames.colorgama;

import java.util.Objects;
import java.util.function.BiFunction;

/**
 * This class implements {@link ComputeDifficultyValue}.
 *
 */
public final class ComputeDifficultyValueImpl implements ComputeDifficultyValue {

    private static final int BASE = 4;
    private static final int OFFSET = 20;
    private static final int ORIGIN = 30;
    private static final int BOUND = 100;
    private static final int BASE_VALUE = 5;
    private final int gridSize;
    private final int valueRange;
    private final int seconds;
    private final int numColors;

    /**
     * Constructor of {@link ComputeDifficultyValue}.
     * 
     * @param operation
     *          the operation to calculate constants
     */
    public ComputeDifficultyValueImpl(final BiFunction<Integer, Integer, Integer> operation) {
        Objects.requireNonNull(operation, "BiFunction is null");
        this.gridSize = operation.apply(BASE, BASE);
        this.seconds = operation.apply(BASE_VALUE, ORIGIN);
        this.valueRange = operation.apply(-BASE_VALUE, OFFSET);
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
    public int getValueRange() {
        return this.valueRange;
    }

    @Override
    public int getSeconds() {
        return this.seconds;
    }
}

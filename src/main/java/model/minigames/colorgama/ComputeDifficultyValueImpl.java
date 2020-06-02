package model.minigames.colorgama;

import java.util.Objects;
import java.util.function.BiFunction;

/**
 * This class implements {@link ComputeDifficultyValue}.
 *
 */
public final class ComputeDifficultyValueImpl implements ComputeDifficultyValue {

    private static final int BASE = 4;
    private static final int OFFSET = 30;
    private static final double ORIGIN = 0.50;
    private static final int BOUND = 1;
    private static final int BASE_HUE = -5;
    private static final int BASE_SECONDS = 5;
    private static final int HUNDRED = 100;
    private final int gridSize;
    private final int decimalNumber;
    private final int hueRange;
    private final double valueRange;
    private final int seconds;

    /**
     * Constructor of {@link ComputeDifficultyValue}.
     * 
     * @param operation
     *          the operation to calculate constants
     *
     * @throws IllegalStateException
     *          if parameters are null
     */
    public ComputeDifficultyValueImpl(final BiFunction<Integer, Integer, Integer> operation) {
        Objects.requireNonNull(operation, "BiFunction is null");
        this.gridSize = operation.apply(BASE, BASE);
        this.decimalNumber = operation.apply(BOUND, BOUND);
        this.seconds = operation.apply(BASE_SECONDS, OFFSET);
        this.hueRange = operation.apply(BASE_HUE, OFFSET);
        this.valueRange = (double) hueRange / HUNDRED;
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
    public double getColorRange() {
        return this.valueRange;
    }

    @Override
    public double getRandomColorOrigin() {
        return ORIGIN;
    }

    @Override
    public double getRandomColorBound() {
        return BOUND - this.getColorRange();
    }

    @Override
    public String contextSettings() {
        return "precision=" + this.decimalNumber + " roundingMode=DOWN";
    }

    @Override
    public int getHueRange() {
        return this.hueRange;
    }

    @Override
    public int getSeconds() {
        return this.seconds;
    }
}

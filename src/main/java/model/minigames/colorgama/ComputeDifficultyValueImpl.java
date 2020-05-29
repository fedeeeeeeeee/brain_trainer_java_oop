package model.minigames.colorgama;

import java.util.function.BiFunction;

import model.DifficultyLevel;

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
     * @param difficulty
     *          the current difficulty.
     *
     * @throws IllegalStateException
     *          if parameters are null
     */
    public ComputeDifficultyValueImpl(final DifficultyLevel difficulty) {
        this.check(difficulty);
        final BiFunction<Integer, Integer, Integer> calculator = (i1, i2) -> i1 * difficulty.ordinal() + i2;
        this.gridSize = calculator.apply(BASE, BASE);
        this.decimalNumber = calculator.apply(BOUND, BOUND);
        this.seconds = calculator.apply(BASE_SECONDS, OFFSET);
        this.hueRange = calculator.apply(BASE_HUE, OFFSET);
        this.valueRange = (double) hueRange / HUNDRED;
    }

    private void check(final DifficultyLevel difficulty) {
        if (difficulty == null) {
            throw new IllegalStateException();
        }
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
        return "precision=" + this.decimalNumber + " roundingMode=HALF_UP";
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

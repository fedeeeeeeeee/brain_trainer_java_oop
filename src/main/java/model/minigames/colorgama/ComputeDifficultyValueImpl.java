package model.minigames.colorgama;

import model.DifficultyLevel;

/**
 * This class implements {@link ComputeDifficultyValue}.
 *
 */
public final class ComputeDifficultyValueImpl implements ComputeDifficultyValue {

    private static final int BASE_SIZE = 5;
    private static final int OFFSET = 3;
    private static final int DECIMAL = 10;
    private static final double ORIGIN = 0.50;
    private static final double BOUND = 1.0;
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
     */
    public ComputeDifficultyValueImpl(final DifficultyLevel difficulty) {
        this.gridSize =  BASE_SIZE + difficulty.ordinal() * OFFSET;
        this.decimalNumber = difficulty.ordinal() + 1;
        this.valueRange = (double) (DifficultyLevel.values().length - difficulty.ordinal()) / DECIMAL;
        this.hueRange = (int) (this.valueRange * DECIMAL * DECIMAL);
        System.out.println(this.hueRange);
        this.seconds = OFFSET * DECIMAL + difficulty.ordinal() * BASE_SIZE; 
    }

    @Override
    public int getGridSize() {
        return this.gridSize;
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

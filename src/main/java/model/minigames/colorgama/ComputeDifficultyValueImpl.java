package model.minigames.colorgama;

import model.DifficultyLevel;

/**
 * This class implements {@link ComputeDifficultyValue}.
 *
 */
public final class ComputeDifficultyValueImpl implements ComputeDifficultyValue {

    private static final int BASE_SIZE = 5;
    private static final int OFFSET = 3;
    private static final int RANGE = 15;
    private static final double ORIGIN = 0.30;
    private static final double BOUND = 0.75;
    private final int gridSize;

    /**
     * Constructor of {@link ComputeDifficultyValue}.
     * 
     * @param difficulty
     *          the current difficulty.
     */
    public ComputeDifficultyValueImpl(final DifficultyLevel difficulty) {
        this.gridSize =  BASE_SIZE + difficulty.ordinal() * OFFSET;
    }

    @Override
    public int getGridSize() {
        return this.gridSize;
    }

    @Override
    public int getColorRange() {
        return RANGE;
    }

    @Override
    public double getRandomColorOrigin() {
        return ORIGIN;
    }

    @Override
    public double getRandomColorBound() {
        return BOUND;
    }


}

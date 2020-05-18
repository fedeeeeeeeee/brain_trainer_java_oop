package model.minigames.colorGama;

import java.util.Arrays;

import model.DifficultyLevel;

/**
 * This class implements {@link ComputeDifficultyValueImpl}.
 *
 */
public final class ComputeDifficultyValueImpl implements ComputeDifficultyValue {

    private static final int BASE_SIZE = 5;
    private static final int OFFSET = 3;
    private DifficultyLevel difficulty;
    private int gridSize;

    /**
     * Constructor of {@link ComputeDifficultyValue}.
     * 
     * @param difficulty
     *          the current difficulty.
     */
    public ComputeDifficultyValueImpl(final DifficultyLevel difficulty) {
        this.difficulty = difficulty;
        this.computeValues(this.difficulty);
    }

    private void computeValues(final DifficultyLevel difficulty) {
        this.gridSize = BASE_SIZE + (Arrays.asList(DifficultyLevel.values()).indexOf(difficulty) * OFFSET);
    }

    @Override
    public int getGridSize() {
        return this.gridSize;
    }

}

package model.minigames.perilousPath;

import model.DifficultyLevel;

/**
 * Implementation of {@link PerilousPathModel}.
 */
public class PerilousPathModelImpl implements PerilousPathModel {

    private final int size;
    private final int numMines;

    /**
     * Constructor of {@link PerilousPathModel}.
     * 
     * @param difficultyLevel
     *                       the current difficulty level
     */
    public PerilousPathModelImpl(final DifficultyLevel difficultyLevel) {
        Difficulty difficulty = new DifficultyImpl(difficultyLevel);
        this.size = difficulty.getSize();
        this.numMines = difficulty.getNumMines();
    }

}

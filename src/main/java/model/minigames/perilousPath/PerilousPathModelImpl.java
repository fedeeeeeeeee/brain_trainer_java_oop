package model.minigames.perilousPath;

import model.DifficultyLevel;
import model.score.ScoreModel;
import model.score.ScoreModelImpl;

/**
 * Implementation of {@link PerilousPathModel}.
 */
public class PerilousPathModelImpl implements PerilousPathModel {

    /**
     * Perilous Path's base point.
     */
    private static final int BASE_POINT = 5;

    private final int size;
    private final int numMines;
    private final ScoreModel score;

    /**
     * Constructor of {@link PerilousPathModel}.
     * 
     * @param difficultyLevel the current difficulty level
     */
    public PerilousPathModelImpl(final DifficultyLevel difficultyLevel) {
        Difficulty difficulty = new DifficultyImpl(difficultyLevel);
        this.size = difficulty.getSize();
        this.numMines = difficulty.getNumMines();
        this.score = new ScoreModelImpl(difficultyLevel, BASE_POINT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPoint() {
        this.score.addPoint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFinalScore() {
        return this.score.getScore();
    }
}

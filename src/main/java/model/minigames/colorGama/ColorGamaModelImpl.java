package model.minigames.colorGama;

import model.DifficultyLevel;
import model.score.ScoreModel;
import model.score.ScoreModelImpl;

/**
 * This class implements {@link ColorGamaModel}.
 *
 */
public class ColorGamaModelImpl implements ColorGamaModel {

    private static final int BASEPOINT = 5;

    private final ScoreModel score;
    private final ComputeDifficultyValue computeValue;

    /**
     * Constructor of {@link ColorGamaModel}.
     * 
     * @param difficulty
     *          the difficulty selected
     * 
     */
    public ColorGamaModelImpl(final DifficultyLevel difficulty) {
        this.score = new ScoreModelImpl(difficulty, BASEPOINT);
        this.computeValue = new ComputeDifficultyValueImpl(difficulty);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputeDifficultyValue getDifficultyValue() {
        return this.computeValue;
    }

}

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

    /**
     * Constructor of {@link ColorGamaModel}.
     * 
     * @param difficulty
     *          the difficulty selected
     * 
     */
    public ColorGamaModelImpl(final DifficultyLevel difficulty) {
        this.score = new ScoreModelImpl(difficulty, BASEPOINT);
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

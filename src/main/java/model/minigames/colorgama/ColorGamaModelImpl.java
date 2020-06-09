package model.minigames.colorgama;

import java.util.Objects;
import java.util.Random;

import model.DifficultyLevel;
import model.score.ScoreModel;
import model.score.ScoreModelImpl;

/**
 * This class implements {@link ColorGamaModel}.
 *
 */
public class ColorGamaModelImpl implements ColorGamaModel {

    private static final String NULL_ARG = " passed is null";

    private final ScoreModel score;
    private final ComputeDifficultyValue computeValue;
    private final ColorValuesIterator colorIterator;
    private QuestionType question;

    /**
     * Constructor of {@link ColorGamaModel}.
     * 
     * @param difficulty 
     *          the difficulty selected
     */
    public ColorGamaModelImpl(final DifficultyLevel difficulty) {
        Objects.requireNonNull(difficulty, "DifficultyLevel" + NULL_ARG);
        this.computeValue = new ComputeDifficultyValueImpl(difficulty);
        this.score = new ScoreModelImpl(difficulty, this.computeValue.getBasePoint());
        this.colorIterator = new ColorValuesIteratorImpl(
                this.computeValue.getGridSize() * this.computeValue.getGridSize(),
                new HSBColorValuesCalculator(this.computeValue));
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

    /**
     * {@inheritDoc}
     */
    @Override
    public ColorValuesIterator getColorIterator() {
        return this.colorIterator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionType getCurrentQuestion() {
        return this.question;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public QuestionType nextQuestion() {
        this.question = QuestionType.values()[new Random().nextInt(QuestionType.values().length)];
        this.colorIterator.resetValues(this.question);
        return this.question;
    }
}

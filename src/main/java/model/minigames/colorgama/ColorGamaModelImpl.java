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
        Objects.requireNonNull(difficulty, "difficulty is null");
        this.computeValue = new ComputeDifficultyValueImpl((i1, i2) -> i1 * difficulty.ordinal() + i2);
        this.colorIterator = new ColorValuesIteratorImpl(this.computeValue, new HSBColorValuesCalculator(this.computeValue));
        this.score = new ScoreModelImpl(difficulty, this.computeValue.getBasePoint());
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
        this.colorIterator.reset(this.question);
        return this.question;
    }
}

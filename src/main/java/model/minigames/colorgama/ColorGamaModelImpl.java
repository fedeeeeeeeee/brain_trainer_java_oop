package model.minigames.colorgama;

import java.util.Random;

import org.apache.commons.lang3.tuple.Triple;

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
    private final ComputeColor computeColor;
    private QuestionType question;

    /**
     * Constructor of {@link ColorGamaModel}.
     * 
     * @param difficulty 
     *          the difficulty selected
     *
     * @throws IllegalStateException
     *          if parameters are null
     */
    public ColorGamaModelImpl(final DifficultyLevel difficulty) {
        this.check(difficulty);
        this.computeValue = new ComputeDifficultyValueImpl(difficulty);
        this.computeColor = new ComputeColorImpl(this.computeValue);
        this.score = new ScoreModelImpl(difficulty, this.computeValue.getBasePoint());
    }

    private void check(final DifficultyLevel difficulty) {
        if (difficulty == null) {
            throw new IllegalStateException();
        }
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
    public ComputeColor getComputeColor() {
        return this.computeColor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void calculateRightColorValue() {
        this.computeColor.calculateRightValues(this.question);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRightIndex() {
        return this.computeColor.getRightColorIndex();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Triple<Integer, Double, Double> getRightColorValues() {
        return this.computeColor.getRightColor();
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
        this.computeColor.reset();
        return this.question;
    }

}

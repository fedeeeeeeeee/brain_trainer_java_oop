package model.minigames.colorgama;

import java.util.Random;

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
    private final ComputeColor computeColor;
    private QuestionType question;

    /**
     * Constructor of {@link ColorGamaModel}.
     * 
     * @param difficulty
     *          the difficulty selected
     * 
     */
    public ColorGamaModelImpl(final DifficultyLevel difficulty) {
        this.score = new ScoreModelImpl(difficulty, BASEPOINT);
        this.question = QuestionType.values()[new Random().nextInt(QuestionType.values().length)];
        System.out.println(this.question);
        this.computeValue = new ComputeDifficultyValueImpl(difficulty);
        this.computeColor = new ComputeColorImpl(this.computeValue, question);
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
    public int getRightIndex() {
        return this.computeColor.getRightColorIndex(question);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void nextQuestion() {
        this.question = QuestionType.values()[new Random().nextInt(QuestionType.values().length)];
        System.out.println(this.question);
    }

}

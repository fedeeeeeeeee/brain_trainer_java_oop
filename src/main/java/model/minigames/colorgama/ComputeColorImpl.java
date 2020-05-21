package model.minigames.colorgama;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.commons.lang3.tuple.Triple;



/**
 * This class implements {@link ComputeColor}.
 *
 */
public class ComputeColorImpl implements ComputeColor {

    private static final int DEGREE = 360;

    private final ComputeDifficultyValue difficultyValue;
    private final List<Triple<Integer, Double, Double>> valuesList; 
    private Integer hue;

    /**
     * Constructor of {@link ComputeColor}.
     * 
     * @param difficultyValue
     *          constants according to the difficulty.
     * @param question
     *          the current question.
     */
    public ComputeColorImpl(final ComputeDifficultyValue difficultyValue, final QuestionType question) {
        this.difficultyValue = difficultyValue;
        this.valuesList = new LinkedList<>();
        this.calculateHue();
    }

    private void calculateHue() {
        this.hue = new Random().nextInt(DEGREE + 1);
    }

    private Double calulateRandomValue() {
        return new Random().doubles(this.difficultyValue.getRandomColorOrigin(), this.difficultyValue.getRandomColorBound())
                .iterator().nextDouble();
    }

    private Optional<Triple<Integer, Double, Double>> calculateRightValues(final QuestionType question) {
        switch (question) {
        case DARKEST:
            return this.valuesList.stream().max((c1, c2) -> Double.compare(c1.getMiddle() - c1.getRight(), c2.getMiddle() - c2.getRight()));
        case LIGHTEST:
            return this.valuesList.stream().max((c1, c2) -> Double.compare(c1.getRight() - c1.getMiddle(), c2.getRight() - c2.getMiddle()));
        case COLOR:
            return Optional.of(this.valuesList.iterator().next());
        default:
            break;
        }
        return Optional.empty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Triple<Integer, Double, Double> nextColorValues() {
        final Triple<Integer, Double, Double> triple = Triple.of(this.hue, this.calulateRandomValue(), this.calulateRandomValue());
        this.valuesList.add(triple);
        return triple;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRightColorIndex(final QuestionType question) {
        return this.valuesList.indexOf(this.calculateRightValues(question).get());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        this.calculateHue();
        this.valuesList.clear();
    }




}

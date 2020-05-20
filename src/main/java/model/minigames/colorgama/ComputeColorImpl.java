package model.minigames.colorgama;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * This class implements {@link ComputeColor}.
 *
 */
public class ComputeColorImpl implements ComputeColor {

    private static final int DEGREE = 360;

    private final ComputeDifficultyValue difficultyValue;
    private final Set<Triple<Integer, Double, Double>> valuesSet; 
    private Triple<Integer, Double, Double> rightValues;
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
        this.valuesSet = new HashSet<>();
        this.calculateHue();
        this.calculateRightValues(question);
    }

    private void calculateHue() {
        this.hue = new Random().nextInt(DEGREE + 1);
    }

    private Double calulateRandomValue() {
        return new Random().doubles(this.difficultyValue.getRandomColorOrigin(), this.difficultyValue.getRandomColorBound())
                .iterator().nextDouble();
    }

    private void calculateRightValues(final QuestionType question) {
        switch (question) {
        case DARKEST:
            this.rightValues = this.valuesSet.stream().max((c1, c2) -> Double.compare(c1.getY() - c1.getZ(), c2.getY() - c2.getZ())).get();
            break;
        case LIGHTEST:
            this.rightValues = this.valuesSet.stream().max((c1, c2) -> Double.compare(c1.getZ() - c1.getY(), c2.getZ() - c2.getY())).get();
            break;
        case COLOR:
            this.rightValues = this.valuesSet.iterator().next();
            break;
        default:
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Triple<Integer, Double, Double> nextColorValues() {
        final Triple<Integer, Double, Double> triple = new TripleImpl<>(this.hue, this.calulateRandomValue(), this.calulateRandomValue());
        this.valuesSet.add(triple);
        return triple;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Triple<Integer, Double, Double> getRightColorValues(final QuestionType question) {
        this.calculateRightValues(question);
        return this.rightValues;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        this.calculateHue();
        this.valuesSet.clear();
    }


}

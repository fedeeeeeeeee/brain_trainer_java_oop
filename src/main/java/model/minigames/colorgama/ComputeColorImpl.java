package model.minigames.colorgama;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.tuple.Triple;

/**
 * This class implements {@link ComputeColor}.
 *
 */
public class ComputeColorImpl implements ComputeColor {

    private static final int DEGREE = 360;

    private final ComputeDifficultyValue difficultyValue;
    private final Set<Triple<Integer, Double, Double>> valuesList;
    private Integer hue;
    private Triple<Integer, Double, Double> rightValues;
    private int rightIndex;

    /**
     * Constructor of {@link ComputeColor}.
     * 
     * @param difficultyValue constants according to the difficulty.
     * 
     * @throws IllegalStateException
     *          if difficultyValue is null
     */
    public ComputeColorImpl(final ComputeDifficultyValue difficultyValue) {
        this.check(difficultyValue);
        this.difficultyValue = difficultyValue;
        this.valuesList = new HashSet<>();
        this.calculateHue();
    }

    private void check(final Object o) {
        if (o == null) {
            throw new IllegalStateException();
        }
    } 

    private void calculateHue() {
        this.hue = new Random().nextInt(DEGREE - this.difficultyValue.getHueRange());
    }

    private Double calulateRandomValue() {
        final double d = new Random()
                .doubles(this.difficultyValue.getRandomColorOrigin(), this.difficultyValue.getRandomColorBound())
                .iterator().nextDouble();
        return new BigDecimal(Double.toString(d)).round(new MathContext(this.difficultyValue.contextSettings())).doubleValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void calculateRightValues(final QuestionType question) {
        this.check(question);
        final Comparator<Triple<Integer, Double, Double>> bComparator = (c1, c2) -> Double.compare(c1.getRight(), c2.getRight());
        final Comparator<Triple<Integer, Double, Double>> sComparator = (c1, c2) -> Double.compare(c1.getMiddle(), c2.getMiddle());
        Triple<Integer, Double, Double> triple;

        this.rightIndex = new Random().nextInt(this.difficultyValue.getGridSize() * this.difficultyValue.getGridSize());
        switch (question) {
        case DARKEST:
            triple = this.valuesList.stream().min(bComparator).stream().max(sComparator).get();
            this.rightValues = Triple.of(triple.getLeft(), triple.getMiddle() + this.difficultyValue.getColorRange(), triple.getRight() - this.difficultyValue.getColorRange());
            break;
        case LIGHTEST:
            triple =  this.valuesList.stream().min(sComparator).stream().max(bComparator).get();
            this.rightValues = Triple.of(triple.getLeft(), triple.getMiddle() - this.difficultyValue.getColorRange(), triple.getRight() + this.difficultyValue.getColorRange());
            break;
        case COLOR:
            this.rightValues = Triple.of(this.hue + this.difficultyValue.getHueRange(), this.calulateRandomValue(), this.calulateRandomValue());
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
        final Triple<Integer, Double, Double> triple = Triple.of(this.hue, this.calulateRandomValue(), this.calulateRandomValue());
        this.valuesList.add(triple);
        return triple;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRightColorIndex() {
        return this.rightIndex;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Triple<Integer, Double, Double> getRightColor() {
        return this.rightValues;
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

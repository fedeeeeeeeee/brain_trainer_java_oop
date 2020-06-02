package model.minigames.colorgama;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
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
    private final ColorValuesGenerator colorValuesGenerator;
    private final Set<Triple<Integer, Double, Double>> colorValuesSet;
    private int hue;
    private Optional<Integer> rightIndex;
    private Optional<Triple<Integer, Double, Double>> rightValues;

    /**
     * Constructor of {@link ComputeColor}.
     * 
     * @param difficultyValue 
     *          constants according to the difficulty.
     * 
     * @throws IllegalStateException
     *          if difficultyValue is null
     */
    public ComputeColorImpl(final ComputeDifficultyValue difficultyValue) {
        Objects.requireNonNull(difficultyValue, "difficultyValue is null");
        this.difficultyValue = difficultyValue;
        this.colorValuesGenerator = new ColorValuesGeneratorImpl();
        this.colorValuesSet = new HashSet<>();
        this.hue = this.colorValuesGenerator.getRandomH(DEGREE - this.difficultyValue.getHueRange());
        this.rightIndex = Optional.empty();
        this.rightValues = Optional.empty();
    }

    private Double calulateRandomValue() {
        final double d = this.colorValuesGenerator.getRandomSB(this.difficultyValue.getRandomColorOrigin(), this.difficultyValue.getRandomColorBound());
        return new BigDecimal(Double.toString(d)).round(new MathContext(this.difficultyValue.contextSettings())).doubleValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void calculateRightValues(final QuestionType question) {
        Objects.requireNonNull(difficultyValue, "question is null");
        final Comparator<Triple<Integer, Double, Double>> bComparator = (c1, c2) -> Double.compare(c1.getRight(), c2.getRight());
        final Comparator<Triple<Integer, Double, Double>> sComparator = (c1, c2) -> Double.compare(c1.getMiddle(), c2.getMiddle());
        Triple<Integer, Double, Double> triple;

        this.rightIndex = Optional.of(new Random().nextInt(this.difficultyValue.getGridSize() * this.difficultyValue.getGridSize()));
        switch (question) {
        case DARKEST:
            triple = this.colorValuesSet.stream().min(bComparator).stream().max(sComparator).get();
            this.rightValues = Optional.of(Triple.of(triple.getLeft(), triple.getMiddle() + this.difficultyValue.getColorRange(), triple.getRight() - this.difficultyValue.getColorRange()));
            break;
        case LIGHTEST:
            triple =  this.colorValuesSet.stream().min(sComparator).stream().max(bComparator).get();
            this.rightValues = Optional.of(Triple.of(triple.getLeft(), triple.getMiddle() - this.difficultyValue.getColorRange(), triple.getRight() + this.difficultyValue.getColorRange()));
            break;
        case COLOR:
            this.rightValues = Optional.of(Triple.of(this.hue + this.difficultyValue.getHueRange(), this.calulateRandomValue(), this.calulateRandomValue()));
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
        this.colorValuesSet.add(triple);
        return triple;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRightColorIndex() {
        return this.rightIndex.orElseThrow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Triple<Integer, Double, Double> getRightColor() {
        return this.rightValues.orElseThrow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        this.hue = this.colorValuesGenerator.getRandomH(DEGREE - this.difficultyValue.getHueRange());
        this.rightIndex = Optional.empty();
        this.rightValues = Optional.empty();
        this.colorValuesSet.clear();
    }
}

package model.minigames.colorgama;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

/**
 * This class implements {@link ColorValuesIterator}.
 *
 */
public class ColorValuesIteratorImpl implements ColorValuesIterator {

    private static final String NULL_ARG = "passed is null";
    private static final String BAD_SIZE = "size must be greater than 0";
    private static final String VALUE_NOT_SET = "values not yet set, call setValues() method first";

    private final ColorValuesCalculator colorCalculator;
    private final int size;
    private int counter;
    private int rightIndex;
    private ColorValues<?> rightValues;
    private Optional<QuestionType> currentQuestion;

    /**
     * Constructor of {@link ColorValuesIterator}.
     * 
     * @param size
     *          the size of the iterator
     * 
     * @param colorCalculator
     *          the color value calculator
     */
    public ColorValuesIteratorImpl(final int size, final ColorValuesCalculator colorCalculator) {
        this.checkArgument(size, colorCalculator);
        this.size = size;
        this.colorCalculator = colorCalculator;
        this.currentQuestion = Optional.empty();
    }

    private void checkArgument(final int size, final ColorValuesCalculator colorCalculator) {
        Objects.requireNonNull(colorCalculator, "ColorValuesCalculator " + NULL_ARG);
        if (size <= 0) {
            throw new IllegalArgumentException(BAD_SIZE);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        if (this.currentQuestion.isEmpty()) {
            throw new IllegalStateException(VALUE_NOT_SET);
        }
        return this.counter < this.size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ColorValues<?> next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return (this.counter++ == this.rightIndex) ? this.rightValues : this.colorCalculator.getRandomColorValues();
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
    public ColorValues<?> getRightColor() {
        return this.rightValues;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resetValues(final QuestionType question) {
        Objects.requireNonNull(question, "QuestionType " + NULL_ARG);
        this.counter = 0;
        this.currentQuestion = Optional.of(question);
        this.colorCalculator.reset();
        this.rightIndex = new Random().nextInt(this.size);
        this.rightValues = this.colorCalculator.calculateRightColor(this.currentQuestion.get()).get();
    }
}

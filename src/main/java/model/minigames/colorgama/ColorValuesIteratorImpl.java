package model.minigames.colorgama;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;

/**
 * This class implements {@link ColorValuesIterator}.
 *
 */
public class ColorValuesIteratorImpl implements ColorValuesIterator {

    private final ColorValuesCalculator colorCalculator;
    private final int size;
    private int counter;
    private Integer rightIndex;
    private ColorValues<?> rightValues;

    /**
     * Constructor of {@link ColorValuesIterator}.
     * 
     * @param difficultyValue 
     *          constants according to the difficulty.
     * 
     * @param colorCalculator
     *          the calculator of colors value
     */
    public ColorValuesIteratorImpl(final ComputeDifficultyValue difficultyValue, final ColorValuesCalculator colorCalculator) {
        Objects.requireNonNull(difficultyValue, "ComputeDifficultyValue passed is null");
        this.colorCalculator = colorCalculator;
        this.size = difficultyValue.getGridSize() * difficultyValue.getGridSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
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
        this.counter = this.counter + 1;
        return (this.counter == this.rightIndex) ? this.rightValues : this.colorCalculator.getRandomColorValues();
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
    public void reset(final QuestionType question) {
        this.counter = -1;
        this.colorCalculator.reset();
        this.rightIndex = new Random().nextInt(this.size);
        this.rightValues = this.colorCalculator.calculateRightColor(question).get();
    }
}

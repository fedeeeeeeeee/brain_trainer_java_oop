package model.minigames.colorgama;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.PrimitiveIterator.OfInt;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class implements {@link ColorValuesCalculator}.
 *
 */
public class HSBColorValuesCalculator implements ColorValuesCalculator {

    private static final int DEGREE = 361;

    private final ComputeDifficultyValue difficultyValue;
    private final Set<HSBValues> colorValuesSet;
    private final OfInt values;
    private int hue;

    /**
     * Constructor of {@link ColorValuesCalculator}.
     * s
     * @param difficultyValue 
     *          constants according to the difficulty.
     */
    public HSBColorValuesCalculator(final ComputeDifficultyValue difficultyValue) {
        Objects.requireNonNull(difficultyValue, "difficultyValue is null");
        this.difficultyValue = difficultyValue;
        this.colorValuesSet = new HashSet<>();
        this.values = new Random().ints(this.difficultyValue.getRandomColorOrigin(), this.difficultyValue.getRandomColorBound()).iterator();
    }

    private Integer calulateRandomValue() {
        return this.values.next();
    }

    private void generateColors() {
        while (this.colorValuesSet.size() < this.difficultyValue.getNumColor()) {
            final HSBValues triple = new HSBValues(this.hue, this.calulateRandomValue(), this.calulateRandomValue());
            this.colorValuesSet.add(triple);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<ColorValues<?>> calculateRightColor(final QuestionType question) {
        final Comparator<HSBValues> bComparator = (c1, c2) -> c1.getValue().getRight() - c2.getValue().getRight();
        final Comparator<HSBValues> sComparator = (c1, c2) -> c1.getValue().getMiddle() - c2.getValue().getMiddle();
        switch (question) {
        case DARKEST:
            return Optional.of(new HSBValues(this.hue,
                    this.colorValuesSet.stream()
                                       .max(sComparator)
                                       .get()
                                       .getValue()
                                       .getMiddle() + this.difficultyValue.getValueRange(),
                    this.colorValuesSet.stream()
                                       .min(bComparator)
                                       .get()
                                       .getValue()
                                       .getRight() - this.difficultyValue.getValueRange()));
        case LIGHTEST:
            return Optional.of(new HSBValues(this.hue,
                    this.colorValuesSet.stream()
                                       .min(sComparator)
                                       .get()
                                       .getValue()
                                       .getMiddle() - this.difficultyValue.getValueRange(),
                    this.colorValuesSet.stream()
                                        .max(bComparator)
                                        .get()
                                        .getValue()
                                        .getRight() + this.difficultyValue.getValueRange()));
        case COLOR:
            return Optional.of(new HSBValues(this.hue + this.difficultyValue.getValueRange(), 
                                             this.calulateRandomValue(),
                                             this.calulateRandomValue()));
        default:
            return Optional.empty();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ColorValues<?> getRandomColorValues() {
        return this.colorValuesSet.stream()
                                  .collect(Collectors.toList())
                                  .get(new Random().nextInt(this.colorValuesSet.size()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        this.colorValuesSet.clear();
        this.hue = new Random().nextInt(DEGREE - this.difficultyValue.getValueRange());
        this.generateColors();
    }
}

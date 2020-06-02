package model.minigames.colorgama;

import java.util.Random;

/**
 * This class implements {@link ColorValuesGenerator}.
 *
 */
public class ColorValuesGeneratorImpl implements ColorValuesGenerator {

    private static final int DEGREE = 360 + 1;

    private final Random rand;

    /**
     * Constructor of {@link ColorValuesGenerator}.
     */
    public ColorValuesGeneratorImpl() {
        this.rand = new Random();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getRandomH() {
        return this.rand.nextInt(DEGREE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getRandomH(final int bound) {
        if (bound < 0 || bound > DEGREE) {
            throw new IllegalArgumentException("Bound value must be positive and less than or equal to 361");
        }
        return this.rand.nextInt(bound);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getRandomSB() {
        return this.rand.nextDouble();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getRandomSB(final double origin, final double bound) {
        if (origin < 0.0 || bound > 1.0) {
            throw new IllegalArgumentException("Origin must be greater than or equal to 0.0 and bound must be less than or equal to 1.0");
        }
        if (bound >= origin) {
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        return this.rand.doubles(origin, bound).iterator().nextDouble();
    }
}

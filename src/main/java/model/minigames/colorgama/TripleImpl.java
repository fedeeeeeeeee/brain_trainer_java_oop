package model.minigames.colorgama;

/**
 * This class implements {@link TripleImpl}.
 * 
 * @param <X>
 *          the first element
 * @param <Y>
 *          the second element
 * @param <Z>
 *          the third element
 *
 */
public final class TripleImpl<X, Y, Z> implements Triple<X, Y, Z> {

    private final X first;
    private final Y second;
    private final Z third;

    /**
     * Constructor of {@link Triple}.
     * @param first
     *          the first element
     * @param second
     *          the second element
     * @param third
     *          the third element
     */
    public TripleImpl(final X first, final Y second, final Z third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public X getX() {
        return this.first;
    }

    @Override
    public Y getY() {
        return this.second;
    }

    @Override
    public Z getZ() {
        return this.third;
    }

}

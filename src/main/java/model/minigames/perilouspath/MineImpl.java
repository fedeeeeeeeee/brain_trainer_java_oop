package model.minigames.perilouspath;

import utility.Pair;

/**
 * Implementation of {@link Mine}.
 */
public class MineImpl implements Mine {

    private final Pair<Integer, Integer> mine;
    private MineState mineState;

    /**
     * Constructor of {@link Mine}.
     * 
     * @param mine
     */
    public MineImpl(final Pair<Integer, Integer> mine) {
        this.mine = mine;
        this.mineState = MineState.UNDETONATED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<Integer, Integer> getMinePosition() {
        return this.mine;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setExploded() {
        this.mineState = MineState.EXPLODED;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExploded() {
        return this.mineState.isExploded();
    }
}

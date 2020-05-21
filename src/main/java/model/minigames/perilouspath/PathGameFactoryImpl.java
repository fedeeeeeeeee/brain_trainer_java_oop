package model.minigames.perilouspath;

import utility.Pair;

/**
 * Implementation of {@link PathGameFactory}.
 */
public class PathGameFactoryImpl implements PathGameFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public PathGame createRandomDirectionPath(final Difficulty difficulty, final Pair<Integer, Integer> start, final Pair<Integer, Integer> finish) {
        return new PathGameImpl(difficulty, start, finish);
    }
}

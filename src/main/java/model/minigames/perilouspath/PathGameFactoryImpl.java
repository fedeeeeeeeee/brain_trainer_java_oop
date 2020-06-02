package model.minigames.perilouspath;

import java.util.Objects;
import java.util.Random;

import utility.Pair;

/**
 * Implementation of {@link PathGameFactory}.
 */
public class PathGameFactoryImpl implements PathGameFactory {

    private Pair<Integer, Integer> getRandomPosition(final int size) {
        return new Pair<>(new Random().nextInt(size), new Random().nextInt(size));
    }

    private boolean adjacent(final Pair<Integer, Integer> position1, final Pair<Integer, Integer> position2) {
        Objects.requireNonNull(position1);
        Objects.requireNonNull(position2);
        return Math.abs(position1.getX() - position2.getX()) <= 1 && Math.abs(position1.getY() - position2.getY()) <= 1;
    }

    private Pair<Integer, Integer> initStart(final int size) {
        return this.getRandomPosition(size);
    }

    private Pair<Integer, Integer> initFinish(final int size, final Pair<Integer, Integer> start) {
        final Pair<Integer, Integer> finish = this.getRandomPosition(size);
        if (finish.equals(start) || this.adjacent(finish, start)) {
            return this.initFinish(size, start);
        } else {
            return finish;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PathGame createRandomDirectionPath(final int size, final int numMines) {
        final Pair<Integer, Integer> start = this.initStart(size);
        return new PathGameImpl(size, numMines, start, this.initFinish(size, start));
    }
}

package model.minigames.perilouspath;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;
import java.util.function.Predicate;

import utility.Pair;

/**
 * Implementations of {@link PathGame}.
 */
public class PathGameImpl implements PathGame {

    private final int size;
    private final int numMines;
    private final Pair<Integer, Integer> start;
    private final Pair<Integer, Integer> finish;
    private final LinkedList<Pair<Integer, Integer>> path;  //NOPMD

    /**
     * Constructor of {@link PathGame}.
     * 
     * @param size
     *              the size and the number of mines related to the current difficulty level
     * @param numMines 
     * @param start
     *              the initial step
     * @param finish
     *              the end step
     */
    public PathGameImpl(final int size, final int numMines, final Pair<Integer, Integer> start, final Pair<Integer, Integer> finish) {
        Objects.requireNonNull(start);
        Objects.requireNonNull(finish);
        this.check(size);
        this.check(numMines);
        this.size = size;
        this.numMines = numMines;
        this.start = start;
        this.finish = finish;
        this.path = new LinkedList<>();
        this.initPath();
    }

    private void check(final int value) {
        final Predicate<Integer> predicate = (i) -> i == 0;
        if (predicate.test(value)) {
            throw new IllegalStateException();
        }
    }

    private Direction getRandomDirection() {
        final int direction = new Random().nextInt(Direction.values().length);
        return Direction.values()[direction];
    }

    private boolean checkReachLimit(final Pair<Integer, Integer> lastPosition) {
        Objects.requireNonNull(lastPosition);
        return lastPosition.getX() < 0 || lastPosition.getY() < 0 || lastPosition.getX() >= this.size || lastPosition.getY() >= this.size;
    }

    private void setPath() {
        final Direction direction = this.getRandomDirection();
        final Pair<Integer, Integer> lastPosition;
        if (direction == Direction.RIGHT || direction == Direction.LEFT) {
            lastPosition = new Pair<>(this.path.getLast().getX(), this.path.getLast().getY() + direction.horizontal());
        } else {
            lastPosition = new Pair<>(this.path.getLast().getX() + direction.vertical(), this.path.getLast().getY());
        }
        if (!this.path.contains(lastPosition) && !this.checkReachLimit(lastPosition)) {
            this.path.add(lastPosition);
        } else {
            if (this.path.size() >= 2) {
                this.path.remove(this.path.getLast()); 
            }
            this.setPath();
        }
    }

    private void initPath() {
        this.path.clear();
        this.path.add(this.start);
        while (!this.path.getLast().equals(this.finish)) {
            if (this.path.size() < (this.size * this.size) - this.numMines) {
                this.setPath();
            } else {
                this.initPath();
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedList<Pair<Integer, Integer>> getPathList() {
        return this.path;
    }
}

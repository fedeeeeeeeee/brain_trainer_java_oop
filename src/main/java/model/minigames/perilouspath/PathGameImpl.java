package model.minigames.perilouspath;

import java.util.LinkedList;

import utility.Pair;

/**
 * Implementations of {@link PathGame}
 */
public class PathGameImpl implements PathGame {

    private final int size;
    private final int numMines;
    private final Pair<Integer, Integer> start;
    private final Pair<Integer, Integer> finish;
    private LinkedList<Pair<Integer, Integer>> path;
    
    /**
     * Constructor of {@link PathGame}.
     * 
     * @param difficulty
     * @param start
     * @param finish
     */
    public PathGameImpl(final Difficulty difficulty, final Pair<Integer, Integer> start, final Pair<Integer, Integer> finish) {
        this.size = difficulty.getSize();
        this.numMines = difficulty.getNumMines();
        this.start = start;
        this.finish = finish;
        this.path = new LinkedList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinkedList<Pair<Integer, Integer>> getPathList() {
        return this.path;
    }
}

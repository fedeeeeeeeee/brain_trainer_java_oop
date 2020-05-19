package model.minigames.perilouspath;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import model.DifficultyLevel;
import model.score.ScoreModel;
import model.score.ScoreModelImpl;
import utility.Pair;

/**
 * Implementation of {@link PerilousPathModel}.
 */
public class PerilousPathModelImpl implements PerilousPathModel {

    /**
     * Perilous Path's base point.
     */
    private static final int BASE_POINT = 5;

    private final int size;
    private final int numMines;
    private final ScoreModel score;
    private Pair<Integer, Integer> start;
    private Pair<Integer, Integer> finish;
    private Set<Pair<Integer, Integer>> mines;

    /**
     * Constructor of {@link PerilousPathModel}.
     * 
     * @param difficultyLevel the current difficulty level
     */
    public PerilousPathModelImpl(final DifficultyLevel difficultyLevel) {
        Difficulty difficulty = new DifficultyImpl(difficultyLevel);
        this.size = difficulty.getSize();
        this.numMines = difficulty.getNumMines();
        this.score = new ScoreModelImpl(difficultyLevel, BASE_POINT);
        this.mines = new HashSet<>();
    }

    private Pair<Integer, Integer> getRandomPosition() {
        Random random = new Random();
        return new Pair<>(random.nextInt(this.size), random.nextInt(this.size));
    }

    private Pair<Integer, Integer> getRandomMines() {
        Pair<Integer, Integer> mine = this.getRandomPosition();
        return (this.mines.contains(mine) || mine.equals(this.start) || mine.equals(this.finish)) ? this.getRandomPosition() : mine;
    }

    private boolean adjacent(final Pair<Integer, Integer> position1, final Pair<Integer, Integer> position2) {
        return Math.abs(position1.getX() - position2.getX()) <= 1 && Math.abs(position1.getY() - position2.getY()) <= 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hit(final int row, final int col) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initStart() {
        this.start = this.getRandomPosition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initFinish() {
        Pair<Integer, Integer> finish = this.getRandomPosition();
        if (finish.equals(this.start) || this.adjacent(finish, this.start)) {
            this.initFinish();
        } else {
            this.finish = finish;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initMines() {
        for (int i = 0; i < this.numMines; i++) {
            this.mines.add(this.getRandomMines());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<Integer, Integer> getStart() {
        return this.start;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<Integer, Integer> getFinish() {
        return this.finish;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Pair<Integer, Integer>> getMines() {
        return this.mines;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPoint() {
        this.score.addPoint();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFinalScore() {
        return this.score.getScore();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isDone() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFailed() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        this.initStart();
        this.initFinish();
        this.initMines();
    }
}

package model.minigames.perilouspath;

import java.util.HashSet;
import java.util.LinkedList;
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
    private static final int BASE_POINT = 10;

    private final int size;
    private final int numMines;
    private final Difficulty difficulty;
    private final ScoreModel score;
    private Pair<Integer, Integer> start;
    private Pair<Integer, Integer> finish;
    private Set<Pair<Integer, Integer>> mines;
    private final LinkedList<Pair<Integer, Integer>> selected; //NOPMD
    private LinkedList<Pair<Integer, Integer>> path; //NOPMD
    private final PathGameFactory pathFactory;
    private MineState mineState;

    /**
     * Constructor of {@link PerilousPathModel}.
     * 
     * @param difficultyLevel the current difficulty level
     */
    public PerilousPathModelImpl(final DifficultyLevel difficultyLevel) {
        this.difficulty = new DifficultyImpl(difficultyLevel);
        this.pathFactory = new PathGameFactoryImpl();
        this.score = new ScoreModelImpl(difficultyLevel, BASE_POINT);
        this.selected = new LinkedList<>();
        this.path = new LinkedList<>();
        this.size = difficulty.getSize();
        this.numMines = difficulty.getNumMines();
    }

    private Pair<Integer, Integer> getRandomPosition() {
        return new Pair<>(new Random().nextInt(this.size), new Random().nextInt(this.size));
    }

    private Pair<Integer, Integer> getRandomMines() {
        final Pair<Integer, Integer> mine = this.getRandomPosition();
        return this.mines.contains(mine) || this.path.contains(mine) || mine.equals(this.start) || mine.equals(this.finish) ? this.getRandomMines() : mine;
    }

    private boolean couldMove(final Pair<Integer, Integer> position, final Pair<Integer, Integer> last) {
        return Math.abs(position.getX() - last.getX()) + Math.abs(position.getY() - last.getY()) == 1;
    }

    private boolean couldHit(final int row, final int col) {
        final Pair<Integer, Integer> position = new Pair<>(row, col);
        return this.selected.isEmpty() && position.equals(this.start)
                || !this.selected.isEmpty() && this.couldMove(position, this.selected.getLast());
    }

    private boolean adjacent(final Pair<Integer, Integer> position1, final Pair<Integer, Integer> position2) {
        return Math.abs(position1.getX() - position2.getX()) <= 1 && Math.abs(position1.getY() - position2.getY()) <= 1;
    }

    private void initStart() {
        this.start = this.getRandomPosition();
    }

    private void initFinish() {
        final Pair<Integer, Integer> finish = this.getRandomPosition();
        if (finish.equals(this.start) || this.adjacent(finish, this.start)) {
            this.initFinish();
        } else {
            this.finish = finish;
        }
    }

    private void initPath() {
        this.path = this.pathFactory.createRandomDirectionPath(this.difficulty, this.start, this.finish).getPathList();
    }

    private void initMines() {
        this.mineState = MineState.UNDETONATED;
        this.mines = new HashSet<>();
        for (int i = 0; i < this.numMines; i++) {
            this.mines.add(this.getRandomMines());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hit(final int row, final int col) {
        if (this.couldHit(row, col)) {
            if (this.mines.contains(new Pair<>(row, col))) {
                this.mineState = MineState.EXPLODED;
            }
            this.selected.add(new Pair<>(row, col));
            return true;
        }
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
        return !this.selected.isEmpty() && this.selected.getLast().equals(this.finish);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isFailed() {
        return this.mineState.isExploded();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resetGame() {
        this.initStart();
        this.initFinish();
        this.initPath();
        this.initMines();
        this.selected.clear();
    }
}

package model.minigames.oneWay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.DifficultyLevel;
import model.score.ScoreModel;
import model.score.ScoreModelImpl;
import utility.Pair;

/**
 * Implementation of {@link OneWayModel}.
 * 
 *
 */
public class OneWayModelImpl implements OneWayModel {

    private static final int EASY_LEVEL_ARROW = 3;
    private static final int NORMAL_LEVEL_ARROW = 4;
    private static final int HARD_LEVEL_ARROW = 5;

    private static final int EASY_LEVEL_SEC = 45;
    private static final int NORMAL_LEVEL_SEC = 30;
    private static final int HARD_LEVEL_SEC = 40;

    private static final int SIZE = 6;
    private static final int BASE_POINT = 10;

    private final ScoreModel score;
    private final List<Direction> steps;
    private final DifficultyLevel difficulty;
    private final int size;
    private int arrows;
    private int duration;

    private Pair<Integer, Integer> currentPosition;
    private Pair<Integer, Integer> initialPosition;
    private Pair<Integer, Integer> finalPosition;

    /**
     * OneWayModelImpl constructor.
     * @param selectedDifficulty
     *                        the difficulty to set
     */
    public OneWayModelImpl(final DifficultyLevel selectedDifficulty) {
        this.difficulty = selectedDifficulty;
        this.score = new ScoreModelImpl(this.difficulty, BASE_POINT);
        this.size = SIZE;
        this.steps = new ArrayList<>();
        this.setLevel();
    }

    private void setLevel() {
        switch (this.difficulty) {
        case EASY:
            this.arrows = EASY_LEVEL_ARROW;
            this.duration = EASY_LEVEL_SEC;
            break;
        case NORMAL:
            this.arrows = NORMAL_LEVEL_ARROW;
            this.duration = NORMAL_LEVEL_SEC;
            break;
        case HARD:
            this.arrows = HARD_LEVEL_ARROW;
            this.duration = HARD_LEVEL_SEC;
            break;
        default:
            break;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void oneWayInit() {
        this.resetPath();
        this.setInitialPosition();
        this.drawPath();
    }

    private void resetPath() {
        this.steps.clear();
    }

    private void drawPath() {
        for (int i = 0; i < this.arrows; i++) {
            Direction dir = Direction.generateStep();
            Pair<Integer, Integer> increment = Direction.delta(dir);

            while (checkX(increment.getX()) || checkY(increment.getY())) {
                dir = Direction.generateStep();
                increment = Direction.delta(dir);
            }
            final int x = increment.getX() + this.currentPosition.getX();
            final int y = increment.getY() + this.currentPosition.getY();
            this.currentPosition = new Pair<>(x, y);

            this.steps.add(dir);

        }

        if (this.currentPosition.getX() == this.initialPosition.getX()
                && this.currentPosition.getY() == this.initialPosition.getY()) {
            this.drawPath();
        } else {
            this.finalPosition = this.currentPosition;
        }
    }

    private boolean checkX(final int x) {
        return x + this.currentPosition.getX() < 0 || x + this.currentPosition.getX() >= size;
    }

    private boolean checkY(final int y) {
        return y + this.currentPosition.getY() < 0 || y + this.currentPosition.getY() >= size;
    }

    private void setInitialPosition() {
        final Random random = new Random();
        this.currentPosition = new Pair<>(random.nextInt(this.size), random.nextInt(this.size));
        this.initialPosition = this.currentPosition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hitFinalPosition(final int row, final int col) {
        return this.finalPosition.getX() == row && this.finalPosition.getY() == col ? true : false;
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
    public int getSeconds() {
        return this.duration;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DifficultyLevel getDifficulty() {
        return this.difficulty;
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
    public int getArrowsCount() {
        return this.arrows;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Direction> getSteps() {
        return this.steps;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<Integer, Integer> getInitialPosition() {
        return this.initialPosition;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<Integer, Integer> getFinalPosition() {
        return this.finalPosition;
    }

}

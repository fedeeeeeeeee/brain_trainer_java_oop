package model.minigames.oneway;

import java.util.List;
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

    private static final int BASE_POINT = 10;
    private static final int SIZE = 6;

    private final ScoreModel score;
    private final DifficultyLevel difficulty;
    private final PathDrawer pathDrawer;
    private int arrows;
    private int duration;

    /**
     * OneWayModelImpl constructor.
     * 
     * @param selectedDifficulty 
     *                       the difficulty to set
     */
    public OneWayModelImpl(final DifficultyLevel selectedDifficulty) {
        this.difficulty = selectedDifficulty;
        this.setLevel();
        this.score = new ScoreModelImpl(this.difficulty, BASE_POINT);
        this.pathDrawer = new OneWayPathDrawerImpl(SIZE, arrows);
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
        this.pathDrawer.drawPath();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hitFinalPosition(final int row, final int col) {
        return this.pathDrawer.getFinalPosition().getX() == row 
                && this.pathDrawer.getFinalPosition().getY() == col ? true : false;
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
    public int getArrowsCount() {
        return this.arrows;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Direction> getSteps() {
        return this.pathDrawer.getSteps();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<Integer, Integer> getInitialPosition() {
        return this.pathDrawer.getInitialPosition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Pair<Integer, Integer> getFinalPosition() {
        return this.pathDrawer.getFinalPosition();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getGridSize() {
        return OneWayModelImpl.SIZE;
    }

}

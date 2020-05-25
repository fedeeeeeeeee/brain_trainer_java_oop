package controller.minigames.perilouspath;

import model.DifficultyLevel;
import model.minigames.perilouspath.PerilousPathModel;
import model.minigames.perilouspath.PerilousPathModelImpl;
import view.controllers.minigames.perilouspath.PerilousPathFxImpl;

/**
 * Implementation of {@link PerilousPathController}.
 */
public class PerilousPathControllerImpl implements PerilousPathController {

    private final PerilousPathModel model;
    private final PerilousPathFxImpl view;

    /**
     * Constructor of {@link PerilousPathController}.
     * 
     * @param difficultyLevel 
     *                       the current difficulty level
     * @param perilousPathFx 
     *                       the view controller
     */
    public PerilousPathControllerImpl(final DifficultyLevel difficultyLevel, final PerilousPathFxImpl perilousPathFx) {
        this.view = perilousPathFx;
        this.model = new PerilousPathModelImpl(difficultyLevel);
    }

    private void updateView() {
        this.view.restartGameTimer();
        this.view.reset();
        this.view.showStart(this.model.getStart());
        this.view.showFinish(this.model.getFinish());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resetView() {
        this.view.pauseGameTimer();
        this.view.startSecondaryTimer();
        this.model.resetGame();
        this.view.reset();
        this.view.showMines(this.model.getMines());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.view.drawGrid(this.model.getSize());
        this.view.startGameTimer();
        this.resetView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hitAttempt(final int row, final int col) {
        if (this.model.hit(row, col)) {
            this.view.showStep(row, col);
        }
        if (this.model.isDone()) {
            this.model.addPoint();
            this.resetView();
        }
        if (this.model.isFailed()) {
            this.view.showMines(this.model.getMines());
            this.view.showExplosion(row, col);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void secondaryTimerExpired() {
        this.updateView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timerExpired() {
        this.view.endGame(this.model.getFinalScore());
    }
}

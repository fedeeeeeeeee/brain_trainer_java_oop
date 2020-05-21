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
        this.view.showStart(this.model.getStart());
        this.view.showFinish(this.model.getFinish());
    }

    private void resetView() {
        this.view.showMines(this.model.getMines());
    }

    private void hangingView(final int row, final int col) {
        this.view.showExplosion(row, col);
        this.updateView();
        this.resetView();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.view.drawGrid(this.model.getSize());
        this.model.resetGame();
        this.updateView();
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
            this.startGame();
        }
        if (this.model.isFailed()) {
            this.hangingView(row, col);
            this.startGame();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timerExpired() {
        this.view.endGame(this.model.getFinalScore());
    }
}

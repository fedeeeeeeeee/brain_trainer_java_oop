package controller.minigames.perilouspath;

import java.util.Timer;
import model.DifficultyLevel;
import model.minigames.perilouspath.PerilousPathModel;
import model.minigames.perilouspath.PerilousPathModelImpl;
import timer.GameTimer;
import view.controllers.minigames.perilouspath.PerilousPathFxImpl;

/**
 * Implementation of {@link PerilousPathController}.
 */
public class PerilousPathControllerImpl implements PerilousPathController {

    private final PerilousPathModel model;
    private final PerilousPathFxImpl view;
    private final Timer timer;
    private final GameTimer gameTimer;

    /**
     * Constructor of {@link PerilousPathController}.
     * 
     * @param difficultyLevel 
     *                       the current difficulty level
     * @param perilousPathFx 
     *                       the view controller
     */
    public PerilousPathControllerImpl(final DifficultyLevel difficultyLevel, final PerilousPathFxImpl perilousPathFx) {
        this.model = new PerilousPathModelImpl(difficultyLevel);
        this.view = perilousPathFx;
        this.timer = new Timer();
        this.gameTimer = new GameTimer(this.model.getSeconds(), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateView() {
        this.gameTimer.restart();
        this.view.showStart(this.model.getStart());
        this.view.showFinish(this.model.getFinish());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resetView() {
        this.gameTimer.pause();
        this.model.resetGame();
        this.view.showMines(this.model.getMines());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGame() {
        this.view.drawGrid(this.model.getSize());
        this.startTimer();
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
            this.view.restore();
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
    public void updateTimerView(final int second) {
        this.view.showTimerSeconds(second);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startTimer() {
        this.timer.schedule(this.gameTimer, 0, 1000);
        this.view.setInitialSeconds(this.model.getSeconds());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stopTimer() {
        this.timer.cancel();
        this.gameTimer.cancel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeFinish() {
        this.view.showEndGame(this.model.getFinalScore());
    }
}

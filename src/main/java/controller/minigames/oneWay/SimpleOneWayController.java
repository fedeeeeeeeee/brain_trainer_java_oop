package controller.minigames.oneWay;

import java.util.Timer;

import model.DifficultyLevel;
import model.minigames.oneWay.OneWayModel;
import model.minigames.oneWay.OneWayModelImpl;
import timer.GameTimer;
import view.controllers.minigames.oneWay.OneWayFxImpl;

public class SimpleOneWayController implements OneWayController {
  

    private final OneWayFxImpl view;
    private final OneWayModel model;

    private final GameTimer gameTimer;
    private final Timer timer;
    
    public SimpleOneWayController(final OneWayFxImpl oneWayFx, final DifficultyLevel difficultyLevel) {
        this.view = oneWayFx;
        this.model = new OneWayModelImpl(difficultyLevel);
        this.timer = new Timer();
        this.gameTimer = new GameTimer(this.model.getSeconds(), this);
    }

    @Override
    public void hit(final int row, final int col) {
        if (this.model.hitFinalPosition(row, col)) {
            this.model.addPoint();
        }
    }

    @Override
    public void timeExpired() {
        this.view.showEndGame(this.model.getFinalScore());
    }

    @Override
    public void nextLevel() {
        this.model.initializeOneWay();
        this.view.updateArrows(this.model.getSteps());
        this.view.updateView(this.model.getInitialPosition());
    }

    @Override
    public void showSolution() {
        this.view.showCorrectAnswer(this.model.getFinalPosition());
    }

    @Override
    public void firstInit() {
        this.model.initializeOneWay();
        this.view.drawGrid(this.model.getSize());
        this.view.drawArrow(this.model.getSteps());
        this.view.updateView(this.model.getInitialPosition());
    }

    @Override
    public void updateTimerView(int second) {
        this.view.showTimerSeconds(second);
    }

    @Override
    public void timeFinish() {
        this.view.showEndGame(this.model.getFinalScore());
    }

    @Override
    public void startTimer() {
        this.timer.schedule(this.gameTimer, 0, 1000);
        this.view.setInitialSeconds(this.model.getSeconds());
    }
    
    @Override
    public void stopTimer() {
        this.timer.cancel();
        this.gameTimer.cancel();
    }
}

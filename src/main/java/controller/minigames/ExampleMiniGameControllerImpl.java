package controller.minigames;

import java.util.Timer;

import model.DifficultyLevel;
import model.minigames.ExampleMiniGameModel;
import timer.GameTimer;
import view.controllers.minigames.ExampleMiniGameControllerFx;

/**
 * 
 *
 */
public class ExampleMiniGameControllerImpl implements MiniGameController {

    private static final int BASE_POINT = 5;
    private static final int SECONDS = 30;

    private final ExampleMiniGameControllerFx view;
    private final ExampleMiniGameModel model;
    private final GameTimer gameTimer;
    private final Timer timer;

    public ExampleMiniGameControllerImpl(ExampleMiniGameControllerFx view, DifficultyLevel difficulty) {
        this.timer = new Timer();
        this.gameTimer = new GameTimer(SECONDS, this);
        this.model = new ExampleMiniGameModel(difficulty, BASE_POINT);
        this.view = view;
    }

    @Override
    public void updateTimerView(final int second) {
        this.view.showTimerSeconds(second);
    }

    @Override
    public void timeFinish() {
        this.view.showEndGame(this.model.getFinalScore());
    }

    public void addPoint() {
        this.model.addPoint();
    }

    public void startTimer() {
//        this.gameTimer = new GameTimer(SECONDS, this);
        this.timer.schedule(this.gameTimer, 0 , 1000);
        this.view.setInitialSeconds(SECONDS);
    }

    public void stopTimer() {
        this.timer.cancel();
        this.gameTimer.cancel();
        
    }

}

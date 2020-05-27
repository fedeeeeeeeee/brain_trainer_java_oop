package view.controllers.minigames;

import controller.minigames.ExampleMiniGameControllerImpl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.DifficultyLevel;
import model.minigames.ExampleMiniGameModel;
import timer.GameTimer;
import view.SceneType;

public class ExampleMiniGameControllerFx extends AbstractMiniGameControllerFx {

    private static final int SECONDS = 10;
    private ExampleMiniGameControllerImpl exampleController;
    private boolean pause;

    @FXML
    private Button btn;

    @FXML
    private Button addPoint;

    @FXML
    private Button pauseBtn;

    @FXML
    private Label scoreLbl;

    @FXML
    private void btnOnClickHandler() throws InterruptedException {
//        this.setGameTimer(new GameTimer(SECONDS, this)); 
    }

    @FXML
    private void addPointOnClickHandler() throws InterruptedException {
       this.exampleController.addPoint();
    }

    @FXML
    private void pauseOrRestartTimer() {
//        if (!this.pause) {
//            this.getGameTimer().pause();
//            this.pause = true;
//        } else {
//            this.getGameTimer().restart();
//            this.pause = false;
//        }
    }

    @Override
    public void showEndGame(int finalScore) {
        Platform.runLater(() -> {
            this.scoreLbl.setText(Integer.toString(finalScore));
            this.getController().updateProgress(finalScore);
            this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
        });
    }

    @Override
    public void initGame() {
        this.exampleController = new ExampleMiniGameControllerImpl(this, this.getController().getDifficultyLevel());
        this.exampleController.startTimer();
        this.pause = false;
    }

    @Override
    public void stopTimer() {
        this.exampleController.stopTimer();
        
    }
}

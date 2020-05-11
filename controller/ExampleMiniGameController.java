package minigames.example.controller;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import minigames.AbstractMiniGameController;
import minigames.example.model.ExampleMiniGameModel;
import model.DifficultyLevel;
import timer.GameTimer;

public class ExampleMiniGameController extends AbstractMiniGameController {

    private static final int SECONDS = 10;
    private ExampleMiniGameModel model;
    private boolean pause;

    @FXML
    private Button btn;

    @FXML
    private Button addPoint;

    @FXML
    private Button pauseBtn;

    @FXML
    private Label scoreLbl;

    public ExampleMiniGameController() {
        //this.setGameTimer();
        this.model = new ExampleMiniGameModel(DifficultyLevel.EASY, 5);
        this.pause = false;
    }

    @FXML
    private void btnOnClickHandler() throws InterruptedException {
        this.setGameTimer(new GameTimer(SECONDS, this)); 
    }

    @FXML
    private void addPointOnClickHandler() throws InterruptedException {
       this.model.addPoint();
    }

    @FXML
    private void pauseOrRestartTimer() {
        if (!this.pause) {
            this.getGameTimer().pause();
            this.pause = true;
        } else {
            this.getGameTimer().restart();
            this.pause = false;
        }
    }

    @Override
    public final void timeFinsh() {
       Platform.runLater(() -> this.scoreLbl.setText(Integer.toString(this.model.getFinalScore())));
    }

}
package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import minigames.AbstractMiniGameController;
import timer.GameTimer;

public class ExampleMiniGameController extends AbstractMiniGameController {

    private static final int SECONDS = 30;
    private boolean pause;

    @FXML
    private Button btn;

    @FXML
    private Button addPoint;

    public ExampleMiniGameController() {
        //this.setGameTimer();
        this.pause = false;
    }

    @FXML
    private void btnOnClickHandler() throws InterruptedException {
        this.setGameTimer(new GameTimer(SECONDS, this)); 
    }

    @FXML
    private void addPointOnClickHandler() throws InterruptedException {
        if (!this.pause) {
            this.getGameTimer().pause();
            this.pause = true;
        } else {
            this.getGameTimer().restart();
            this.pause = false;
        }
    }
}

package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import minigames.AbstractMiniGameController;
import timer.GameTimer;

public class ExampleMiniGameController extends AbstractMiniGameController {

    private static final int SECONDS = 30;

    @FXML
    private Button btn;

    @FXML
    private Button addPoint;

    public ExampleMiniGameController() {
        //this.setGameTimer();
    }

    @FXML
    private void btnOnClickHandler() throws InterruptedException {
        this.setGameTimer(new GameTimer(SECONDS, this)); 
    }

    @FXML
    private void addPointOnClickHandler() throws InterruptedException {
        //this.controllerMinigame.addPoint();
    }
}

package minigames;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.DifficultyLevel;
import timer.GameTimer;
import view.SceneType;

public class ExampleMiniGameController  extends AbstractMiniGameController {

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
    public void timeFinish() {
        Integer score = this.model.getFinalScore();
        Platform.runLater(() -> {
            this.scoreLbl.setText(Integer.toString(score));
            this.getController().updateProgress(score);
            this.getView().setDataScene(SceneType.END_GAME.getFilePath());
        });
    }


    @Override
    public void initGame() {
        // TODO Auto-generated method stub
    }
}

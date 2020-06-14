package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.score.Progress;
import view.SceneType;

/**
 * The fx controller for the end game scene.
 */
public class EndGameFx extends AbstractSceneController implements FxHandleDataScene {

    @FXML
    private Label score;

    @FXML
    private Button backBtn;

    @FXML
    private void backHome() {
        this.getView().switchScene(SceneType.MAIN_MENU.getFilePath());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(Progress progress) {
        this.score.setText("Score: " + Integer.toString(progress.getCurrentScore()) + "\nBest: "
                + Integer.toString(progress.getCurrentBest()));

    }

}

package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import view.SceneType;

/**
 * The fx controller for the end game scene.
 */
public class EndGameFx extends AbstractSceneController implements FxController {

    @FXML
    private Label score;
    
    @FXML
    private Button backBtn;

    @Override
    public void init() {
        this.score.setText("Score: " + Integer.toString(this.getController().getCurrentScore()) +
                           "\nBest: " + Integer.toString(this.getController().getCurrentMiniGameBest()));
    }
    
    @FXML
    private void backHome() {
        this.getView().switchScene(SceneType.MAIN_MENU.getFilePath());
    }

}

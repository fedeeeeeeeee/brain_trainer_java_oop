package view.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * The fx controller for the end game scene.
 */
public class EndGameFx extends AbstractSceneController implements FxDataScene {

    @FXML
    private Label score;

    @Override
    public void init() {
        this.score.setText("Score: " + Integer.toString(this.getController().getCurrentScore()) +
                           "\nBest: " + Integer.toString(this.getController().getCurrentMiniGameBest()));
    }

}

package view.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import view.ViewScene;

/**
 * The fx controller for Statistics scene.
 *
 */
public class StatisticsFx extends AbstractSceneController {

    @FXML
    private Button backBtn;

    // TODO

    @FXML
    private void goBack() throws IOException { // NOPMD
        this.getView().switchScene(ViewScene.MAIN_MENU);
    }
}

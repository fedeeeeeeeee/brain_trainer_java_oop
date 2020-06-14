package view.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import view.SceneType;

/**
 * The fx controller for the howToPlay scene.
 *
 */
public class HowToPlayFx extends AbstractSceneController implements FxNormalScene {

    @FXML
    private Button backBtn;

    @FXML
    private Button gameInfoBtn;

    @FXML
    private TextArea infoTxt;

    @FXML
    private Button brnTrnInfoBtn;

    @FXML
    private void showGameInfo() throws IOException { // NOPMD
        this.scanner("MiniGameInfo");
    }

    @FXML
    private void showIntroduction() throws IOException { // NOPMD
        this.scanner("Introduction");
    }

    @FXML
    private void goBack() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.MAIN_MENU.getFilePath());
    }

    private void scanner(final String fileTxt) {
        infoTxt.clear();
        final String filePath = "src/main/resources/info/" + fileTxt + ".txt";
        try {
            final Scanner scanner = new Scanner(new File(filePath));
            while (scanner.hasNext()) {
                infoTxt.appendText(scanner.nextLine() + "\n");
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
        
    }
}

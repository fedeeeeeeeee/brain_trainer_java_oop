package view.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.DimensionCalculatorImpl;
import view.SceneType;

/**
 * The fx controller for the howToPlay scene.
 *
 */
public class HowToPlayFx extends AbstractSceneController implements FxNormalScene {

    @FXML
    private ImageView backImg;

    @FXML
    private Button gameInfoBtn;

    @FXML
    private TextArea infoTxt;

    @FXML
    private GridPane topGrid;

    private DimensionCalculatorImpl calculator;

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
            final Scanner scanner = new Scanner(new File(filePath));//NOPMD
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
        final Stage stage = (Stage) this.getRoot().getScene().getWindow();
        this.calculator = new DimensionCalculatorImpl(stage);
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.calculator.setNodeFontStyle(topGrid, 0.07, (double) newVal / 2);
            this.infoTxt.setStyle("-fx-font-size: " + 0.05 * (double) newVal / 2);
            this.calculator.setImageViewDimension(backImg, 0.005, (double) newVal/4);
        });
        this.calculator.setActualNodeFontStyle(topGrid, 0.20);
        this.infoTxt.setStyle("-fx-font-size: " + this.gameInfoBtn.getFont().getSize());
        this.calculator.setActualImageViewDimension(backImg, 0.005);
    }
}

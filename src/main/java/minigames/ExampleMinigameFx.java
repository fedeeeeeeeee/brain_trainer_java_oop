package minigames;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import model.DifficultyLevel;
import utility.Pair;
import view.ViewScene;

public class ExampleMinigameFx extends AbstractMiniGameController {

    @FXML
    private Button backBtn;

    @FXML
    private GridPane grid;

    private DifficultyLevel difficultyLevel;
    
    private final Map<Button, Pair<Integer, Integer>> buttons = new HashMap<>();
    
    public void initialize() {    
      //TODO
      this.difficultyLevel = this.getController().getDifficultyLevel();
    }
    
    @FXML
    private void goBack() throws IOException { // NOPMD
        this.getView().switchScene(ViewScene.GAME_SELECTOR.getFilePath());
    }

    @Override
    public void timeFinsh() {
        //TODO
    }

}

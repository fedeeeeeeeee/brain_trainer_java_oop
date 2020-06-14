package view.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.score.Progress;
import utility.Pair;
import view.SceneType;
import view.TrainingArea;

/**
 * The fx controller for Statistics scene.
 *
 */
public class StatisticsFx extends AbstractSceneController implements FxHandleDataScene {

    @FXML
    private Label statistics;

    @FXML
    private Button backBtn;
    
    @FXML
    private VBox vBox;
    
    @FXML
    private void goBack() throws IOException { // NOPMD
        this.getView().switchScene(SceneType.MAIN_MENU.getFilePath());
    }

    private List<Pair<TrainingArea, Integer>> values = new ArrayList<>();
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void init(Progress progress) {
        this.values = progress.getAverageTrainingAreaScore().entrySet()
                .stream()
                .map(e-> new Pair<TrainingArea, Integer>(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        this.values.forEach(p->{
            Label l = new Label(p.getX().getName() + " " + p.getY());  
            l.setFont(Font.font(35));
            this.vBox.getChildren().add(l);
            this.vBox.setAlignment(Pos.CENTER);
        });
        
    }

    
}

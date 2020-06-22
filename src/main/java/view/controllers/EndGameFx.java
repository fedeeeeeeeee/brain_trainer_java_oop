package view.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.score.Progress;
import view.DimensionCalculatorImpl;
import view.SceneType;

/**
 * The fx controller for the end game scene.
 */
public class EndGameFx extends AbstractSceneController implements FxHandleDataScene {

    @FXML
    private GridPane grid;
    
    @FXML
    private GridPane bottomGrid;
    
    @FXML
    private Label score;
    
    @FXML
    private Button homeBtn;
    
    @FXML
    private Label messageLabel;   
    
    @FXML
    private ImageView resultImg;
    
    private DimensionCalculatorImpl calculator;
    
    
    
    @FXML
    private void backHome() { // NOPMD
        this.getView().switchScene(SceneType.MAIN_MENU.getFilePath());
    }
    
    @Override
    public void init(final Progress progress) {
        final int currentScore = progress.getCurrentScore();
        final int bestScore = progress.getCurrentBest();  
        this.score.setText("Score: " + currentScore + "\nBest: " + bestScore);
        score.setBorder(new Border(new BorderStroke(Color.valueOf("#49618c"), BorderStrokeStyle.DASHED, null, new BorderWidths(5))));
        this.messageLabel.setText(currentScore < bestScore ? "You can do better!" : "Keep it going!");
        this.resultImg.setImage(currentScore < bestScore ? new Image("/images/hard-work.png") : new Image("/images/award.png") );
        this.resizeNode();       
    }
    
    private void resizeNode() {
        final Stage stage = (Stage) homeBtn.getScene().getWindow();
        this.calculator = new DimensionCalculatorImpl(stage);              
        stage.widthProperty().addListener((obs, oldVal, newVal) -> {
            this.calculator.setNodeFontStyle(grid, 0.08, (double)newVal / 2);
            this.calculator.setNodeFontStyle(bottomGrid, 0.07, (double)newVal/2);
            resultImg.setStyle("-fx-scale-x : " + 0.005 * (double) newVal / 4 + 
                    ";-fx-scale-y : "+ 0.005 * (double) newVal / 4);
        });           
        this.calculator.setActualNodeFontStyle(grid, 0.10);      
        this.calculator.setActualNodeFontStyle(bottomGrid, 0.20);
    }
}

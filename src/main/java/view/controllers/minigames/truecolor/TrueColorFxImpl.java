package view.controllers.minigames.truecolor;

import java.io.IOException;
import java.util.Map;

import controller.minigames.truecolor.TrueColorController;
import controller.minigames.truecolor.TrueColorControllerImpl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import model.DifficultyLevel;
import timer.GameTimer;
import utility.Pair;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameController;

/**
 * Represents the True Color View.
 */
public class TrueColorFxImpl extends AbstractMiniGameController implements TrueColorFx {
	
	/**
     * The minigame's duration.
     */
	private static final int SECONDS = 30;
	
	private TrueColorController trueColorController;
	
	@FXML
    private Button yesBtn;
    @FXML
    private Button noBtn;
    @FXML
    private Button meanColorBtn;
    @FXML
    private Button trueColorBtn;
	@FXML
	private Button trueColorBtn2;
    @FXML
	private GridPane gridPane;
	
	private Button currentAnswer;
	
	
    @FXML
	private void buttonClicked(MouseEvent event) throws IOException {
    	final String selectedAnswer = ((Button) event.getSource()).getText();
    	this.currentAnswer = (Button) event.getSource();
    	this.trueColorController.check(selectedAnswer);
	}
	
	public void next() {
		this.trueColorController.refresh();
        this.trueColorController.startGame();
	}
	
	
	public void setButton(Map<String, Pair<String, String>> randomColor) {
		meanColorBtn.setText(randomColor.get("meanColorBtn").getX());
		meanColorBtn.setStyle("-fx-text-fill: " + randomColor.get("meanColorBtn").getY());
		trueColorBtn.setText(randomColor.get("trueColorBtn").getX());
		trueColorBtn.setStyle("-fx-text-fill: " + randomColor.get("trueColorBtn").getY());
	}
	
	public void setThreeButton(Map<String, Pair<String, String>> randomColor) {
		meanColorBtn.setText(randomColor.get("meanColorBtn").getX());
		meanColorBtn.setStyle("-fx-text-fill: " + randomColor.get("meanColorBtn").getY());
		trueColorBtn.setText(randomColor.get("trueColorBtn").getX());
		trueColorBtn.setStyle("-fx-text-fill: " + randomColor.get("trueColorBtn").getY());
		trueColorBtn2.setText(randomColor.get("trueColorBtn2").getX());
		trueColorBtn2.setStyle("-fx-text-fill: " + randomColor.get("trueColorBtn2").getY());
	}
	
	public void alternativeSetThreeButton(Map<String, Pair<String, String>> randomColor) {
		meanColorBtn.setText(randomColor.get("meanColorBtn").getX());
		meanColorBtn.setStyle("-fx-text-fill: " + randomColor.get("meanColorBtn").getY());
		trueColorBtn.setStyle("-fx-background-color: " + randomColor.get("trueColorBtn").getY());
		trueColorBtn.setText("");
		trueColorBtn2.setStyle("-fx-background-color: " + randomColor.get("trueColorBtn2").getY());
		trueColorBtn2.setText("");
	}

	 /**
     * {@inheritDoc}
     */
	@Override
	public void initGame() {
		if(!this.getController().getDifficultyLevel().equals(DifficultyLevel.EASY)) { //!!!!
			this.addButton();
		}
		this.trueColorController = new TrueColorControllerImpl(this.getController().getDifficultyLevel(), this);
		this.trueColorController.startGame();
		this.setGameTimer(new GameTimer(SECONDS, this));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void timeFinish() {
		this.trueColorController.timeExpired();	
	}
	
	
	/**
     * Show the final score.
     * 
     * @param finalScore
     */
	public void endGame(final int finalScore) {
		Platform.runLater(() -> {
			this.getController().updateProgress(finalScore);
			this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
		});
	}

	private void addButton() {
		this.trueColorBtn2 = new Button();
		this.trueColorBtn2.setPrefSize(300, 300);
		this.trueColorBtn2.setStyle("-fx-font-size: 30");
		this.gridPane.add(this.trueColorBtn2, 1, 5);
		
	}
	
	// Border button animation correct answer
	private final EventHandler<ActionEvent> event = (e) -> {
		this.currentAnswer.setStyle("-fx-focus-color: transparent;");
        this.currentAnswer.setStyle("-fx-border-color: #000000; -fx-border-width: 0.1px;");
    };
    
	private void animation() {
        final Timeline timeline = new Timeline();
        final KeyFrame kf = new KeyFrame(Duration.millis(300), event);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
	
	public void showWrongAnswer() {
		this.currentAnswer.setStyle("-fx-border-color:#FF0000 ; -fx-border-width: 2px;");
		this.animation();

	}

	public void showCorrectAnswer() {
		this.currentAnswer.setStyle("-fx-border-color:#66FF66 ; -fx-border-width: 2px;");
		this.animation();
	}
	
}

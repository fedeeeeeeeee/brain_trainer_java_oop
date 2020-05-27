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
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.DifficultyLevel;
import timer.GameTimer;
import utility.Pair;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameControllerFx;

/**
 * Represents the True Color View.
 */
public class TrueColorFxImpl extends AbstractMiniGameControllerFx implements TrueColorFx {

	/**
	 * The minigame's duration.
	 */
	private static final String textfill = "-fx-text-fill: ";
	private static final String background = "-fx-background-color: ";
	private boolean pause;
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
	private VBox vBoxId;

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
		meanColorBtn.setStyle(textfill + randomColor.get("meanColorBtn").getY());
		trueColorBtn.setText(randomColor.get("trueColorBtn").getX());
		trueColorBtn.setStyle(textfill + randomColor.get("trueColorBtn").getY());
	}

	// RIPETIZIONEEEEEEEEEEE
	public void setThreeButton(Map<String, Pair<String, String>> randomColor) {
		meanColorBtn.setText(randomColor.get("meanColorBtn").getX());
		meanColorBtn.setStyle(textfill + randomColor.get("meanColorBtn").getY());
		trueColorBtn.setText(randomColor.get("trueColorBtn").getX());
		trueColorBtn.setStyle(textfill + randomColor.get("trueColorBtn").getY());
		trueColorBtn2.setText(randomColor.get("trueColorBtn2").getX());
		trueColorBtn2.setStyle(textfill + randomColor.get("trueColorBtn2").getY());
	}

	public void alternativeSetThreeButton(Map<String, Pair<String, String>> randomColor) {
		meanColorBtn.setText(randomColor.get("meanColorBtn").getX());
		meanColorBtn.setStyle(textfill + randomColor.get("meanColorBtn").getY());
		trueColorBtn.setStyle(background + randomColor.get("trueColorBtn").getY());
		trueColorBtn.setText("");
		trueColorBtn2.setStyle(background + randomColor.get("trueColorBtn2").getY());
		trueColorBtn2.setText("");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initGame() {
		if (!this.getController().getDifficultyLevel().equals(DifficultyLevel.EASY)) { // !!!!
			this.addButton();
		}
		this.trueColorController = new TrueColorControllerImpl(this.getController().getDifficultyLevel(), this);
		this.trueColorController.startTimer();
		this.trueColorController.startGame();
	}

	private void addButton() {
//		 for (int i = 0; i < numOperations; i++) {
//	            final Button bt = new Button();
//	            bt.setStyle("-fx-font-size: 20");
//	            // bt.setMinSize(bt.USE_COMPUTED_SIZE, bt.USE_COMPUTED_SIZE);
//	            bt.setPrefWidth(WIDTH);
//	            this.buttons.add(bt);
//	            bt.addEventHandler(MouseEvent.MOUSE_CLICKED, ev);
//	            this.panel.getChildren().add(bt);
//	        }
		this.meanColorBtn = new Button();
		this.meanColorBtn.setPrefSize(300, 300);
		this.meanColorBtn.setStyle("-fx-font-size: 50");
		this.vBoxId.getChildren().add(meanColorBtn);
		
		this.trueColorBtn = new Button();
		this.trueColorBtn.setPrefSize(300, 300);
		this.trueColorBtn.setStyle("-fx-font-size: 50");
		this.vBoxId.getChildren().add(trueColorBtn);
		
		this.trueColorBtn2 = new Button();
		this.trueColorBtn2.setPrefSize(300, 300);
		this.trueColorBtn2.setStyle("-fx-font-size: 50");
		this.vBoxId.getChildren().add(trueColorBtn2);
	}

	// old endGame()
	@Override
	public void showEndGame(int finalScore) {
		Platform.runLater(() -> {
			this.getController().updateProgress(finalScore);
			this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
		});
	}

	@Override
	public void stopTimer() {
		this.trueColorController.stopTimer();
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

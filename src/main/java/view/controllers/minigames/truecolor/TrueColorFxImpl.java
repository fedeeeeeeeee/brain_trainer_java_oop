package view.controllers.minigames.truecolor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
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
import model.minigames.truecolor.Colors;
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
	private List<Button> meaningColorBtnList;
	private List<Button> trueColorBtnList;
	private int meanColorSize = 0;
	private int trueColorSize = 0;

	@FXML
	private Button yesBtn;
	@FXML
	private Button noBtn;
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

	public void setButtons(Map<String, List<Pair<Colors, Colors>>> colorMap) {
//		System.out.println(" meaningList in FxController --> " + meaninglist);
//		System.out.println(" trueColorList in FxController --> " +trueColorlist);
		this.setStyleButton(colorMap.get("randomMeaningColor"), this.meaningColorBtnList);
		this.setStyleButton(colorMap.get("randomTrueColor"), this.trueColorBtnList);
	}

	private void setStyleButton(List<Pair<Colors, Colors>> listColor, List<Button> listBtn) {
		int size = listBtn.size();
		for (int i = 0; i < size; i++) {
			listBtn.get(i).setText(listColor.get(i).getX().toString());
			listBtn.get(i).setStyle(textfill + listColor.get(i).getY().getName());
		}
	}
	
	public void alternativeSetButton(List<Pair<Colors, Colors>> list) {
		int size = this.trueColorBtnList.size();
		for (int i = 0; i < size; i++) {
			this.trueColorBtnList.get(i).setText("");
			this.trueColorBtnList.get(i).setStyle(background + list.get(i).getY().getName());
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initGame() {
		this.trueColorController = new TrueColorControllerImpl(this.getController().getDifficultyLevel(), this);
		this.addButtons();
		this.trueColorController.startTimer();
		this.trueColorController.startGame();
	}
	
	private void addButtons() {
		this.meaningColorBtnList = new LinkedList<>();
		this.trueColorBtnList = new LinkedList<>();
		this.addButtonGeneral(this.meaningColorBtnList, this.meanColorSize);
		this.addButtonGeneral(this.trueColorBtnList, this.trueColorSize);
	}
	
	private void addButtonGeneral(List<Button> btnList, Integer size) {
		for (int i = 0; i < size; i++) {
			final Button bt = new Button();
			bt.setStyle("-fx-font-size: 20");
			bt.setPrefSize(300, 300);
			btnList.add(bt);
			this.vBoxId.getChildren().add(bt);
		}
	}
	
	public void setNumberBtn(Integer meaningColor, Integer trueColor) {
		this.meanColorSize= meaningColor;
		this.trueColorSize = trueColor;
		
	}

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

	// Border button animation correct answer---------------
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

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
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.minigames.truecolor.Colors;
import utility.Pair;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameControllerFx;

/**
 * Represents the True Color View.
 */
public class TrueColorFxImpl extends AbstractMiniGameControllerFx implements TrueColorFx {

	private static final String TXTFILL = "-fx-text-fill: ";
	private static final String BACKGROUND = "-fx-background-color: ";
	private static final String FONT = "-fx-font-size: ";
	private static final String BORDERC = "-fx-border-color: ";
	private static final String BORDERW = "-fx-border-width: ";
	private static final String NOFOCUS = "-fx-focus-color: transparent";
	private TrueColorController trueColorController;
	private List<Button> meaningColorBtnList;
	private List<Button> trueColorBtnList;
	private int meanColorSize;
	private int trueColorSize;
	private Button currentAnswer;
	
	@FXML
	private VBox vBoxId;

	private final EventHandler<ActionEvent> event = (e) -> {
		this.currentAnswer.setStyle(BORDERC + "#000000;" + BORDERW + "0.3px;" + NOFOCUS);
	};
	
	@FXML
	private void buttonClicked(final MouseEvent event) throws IOException { //NOPMD
		final String selectedAnswer = ((Button) event.getSource()).getText();
		this.currentAnswer = (Button) event.getSource();
		this.trueColorController.check(selectedAnswer);
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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void next() {
		this.trueColorController.refresh();
		this.trueColorController.startGame();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setButtons(final Map<String, List<Pair<Colors, Colors>>> colorMap) {
		this.setStyleButton(colorMap.get("randomMeaningColor"), this.meaningColorBtnList);
		this.setStyleButton(colorMap.get("randomTrueColor"), this.trueColorBtnList);
	}

	private void setStyleButton(final List<Pair<Colors, Colors>> listColor, final List<Button> listBtn) {
		final int size = listBtn.size();
		for (int i = 0; i < size; i++) {
			listBtn.get(i).setText(listColor.get(i).getX().toString());
			listBtn.get(i).setStyle(TXTFILL + listColor.get(i).getY().getName() + ";" + FONT + "35");
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void alternativeSetButton(final List<Pair<Colors, Colors>> list) {
		final int size = this.trueColorBtnList.size();
		for (int i = 0; i < size; i++) {
			this.trueColorBtnList.get(i).setText("");
			this.trueColorBtnList.get(i).setStyle(BACKGROUND + list.get(i).getY().getName());
		}
	}

	
	private void addButtons() {
		this.meaningColorBtnList = new LinkedList<>();
		this.trueColorBtnList = new LinkedList<>();
		this.addButtonGeneral(this.meaningColorBtnList, this.meanColorSize);
		this.addButtonGeneral(this.trueColorBtnList, this.trueColorSize);
	}
	
	private void addButtonGeneral(final List<Button> btnList, final Integer size) {
		for (int i = 0; i < size; i++) {
			final Button bt = new Button();
			bt.setPrefSize(300, 100);
			btnList.add(bt);
			this.vBoxId.getChildren().add(bt);
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setNumberBtn(final Map<String, List<Pair<Colors, Colors>>> colorMap) {
	this.meanColorSize= colorMap.get("randomMeaningColor").size();
	this.trueColorSize = colorMap.get("randomTrueColor").size();
	}
	

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void showEndGame(final int finalScore) {
		Platform.runLater(() -> {
			this.getController().updateProgress(finalScore);
			this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stopTimer() {
		this.trueColorController.stopTimer();
	}

	private void animation() {
		final Timeline timeline = new Timeline();
		final KeyFrame kf = new KeyFrame(Duration.millis(300), event);
		timeline.getKeyFrames().add(kf);
		timeline.play();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void showWrongAnswer() {
		this.currentAnswer.setStyle(BORDERC + "#FF0000;" + BORDERW + "2px;");
		this.animation();

	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void showCorrectAnswer() {
		this.currentAnswer.setStyle(BORDERC + "#66FF66;" + BORDERW + "2px;");
		this.animation();
	}
}

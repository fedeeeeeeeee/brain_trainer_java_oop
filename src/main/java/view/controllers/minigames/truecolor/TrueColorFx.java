package view.controllers.minigames.truecolor;

import java.io.IOException;
import java.util.Map;

import controller.minigames.truecolor.TrueColorController;
import controller.minigames.truecolor.TrueColorControllerImpl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import timer.GameTimer;
import utility.Pair;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameController;

/**
 * Represents the True Color View.
 */
public class TrueColorFx extends AbstractMiniGameController{
	
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
	private void buttonClicked(MouseEvent event) throws IOException {
    	final String selectedAnswer = ((Button) event.getSource()).getText();
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
	
	 /**
     * {@inheritDoc}
     */
	@Override
	public void initGame() {
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

}

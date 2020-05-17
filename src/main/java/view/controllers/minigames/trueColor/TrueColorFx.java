package view.controllers.minigames.trueColor;

import java.io.IOException;

import controller.minigames.trueColor.TrueColorController;
import controller.minigames.trueColor.TrueColorControllerImpl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import timer.GameTimer;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameController;

/**
 * Represents the True Color View.
 */
public class TrueColorFx extends AbstractMiniGameController{
	
	/**
     * The Perilous Path's duration.
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
    
	 /**
     * {@inheritDoc}
     */
	@Override
	public void initGame() {
		this.trueColorController = new TrueColorControllerImpl(this.getController().getDifficultyLevel(), this);
        this.setGameTimer(new GameTimer(SECONDS, this));
	}

	@FXML
	private void buttonClicked(MouseEvent event) throws IOException {
		// TODO
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

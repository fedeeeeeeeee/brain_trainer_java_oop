package view.controllers.minigames.colorGama;

import controller.minigames.colorGama.ColorGamaController;
import controller.minigames.colorGama.ColorGamaControllerImpl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import timer.GameTimer;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameController;

/**
 * This class implements {@link ColorGamaView}.
 *
 */
public class ColorGamaViewImpl extends AbstractMiniGameController implements ColorGamaView {

    private static final int SECONDS = 30;

    @FXML
    private GridPane buttonsGrid;

    private ColorGamaController colorGamaController;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.colorGamaController = new ColorGamaControllerImpl(this, this.getController().getDifficultyLevel());
        this.setGameTimer(new GameTimer(SECONDS, this)); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeFinish() {
       this.colorGamaController.timeExpired();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void endGame(final int finalScore) {
        Platform.runLater(() -> {
            this.getController().updateProgress(finalScore);
            this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
        });

    }
}

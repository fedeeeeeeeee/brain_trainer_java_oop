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
 * 
 *
 */
public class ColorGamaFx extends AbstractMiniGameController {

    private static final int SECONDS = 30;

    @FXML
    private GridPane buttonsGrid;

    private ColorGamaController colorGamaController;

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeFinish() {
        Platform.runLater(() -> {
            this.getController().updateProgress(this.colorGamaController.getFinalScore());
            this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
        });

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.colorGamaController = new ColorGamaControllerImpl(this.getController().getDifficultyLevel());
        this.setGameTimer(new GameTimer(SECONDS, this)); 
    }

}

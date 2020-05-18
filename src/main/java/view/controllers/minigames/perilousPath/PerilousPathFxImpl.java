package view.controllers.minigames.perilousPath;

import controller.minigames.perilousPath.PerilousPathController;
import controller.minigames.perilousPath.PerilousPathControllerImpl;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import timer.GameTimer;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameController;

/**
 * Represents the Perilous Path View.
 */
public class PerilousPathFxImpl extends AbstractMiniGameController implements PerilouPathFx {

    /**
     * The Perilous Path's duration.
     */
    private static final int SECONDS = 31;

    private PerilousPathController controller;

    @FXML
    private GridPane grid;

    @FXML
    private Label instructions;

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.controller = new PerilousPathControllerImpl(this.getController().getDifficultyLevel(), this);
        this.setGameTimer(new GameTimer(SECONDS, this));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeFinish() {
        this.controller.timerExpired();
    }

    /**
     * {@inheritDoc}
     */
    public void endGame(final int finalScore) {
        Platform.runLater(() -> {
            this.getController().updateProgress(finalScore);
            this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
        });
    }
}

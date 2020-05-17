package view.controllers.minigames.colorGama;

import controller.minigames.colorGama.ColorGamaController;
import controller.minigames.colorGama.ColorGamaControllerImpl;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
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
    private EventHandler<MouseEvent> eventHandler = (l) -> {

    };

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawGrid(final int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final Button bt = new Button();
                bt.setPrefSize(100, 100);
                bt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                bt.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
                GridPane.setMargin(bt, new Insets(2));
                buttonsGrid.add(bt, i, j);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.colorGamaController = new ColorGamaControllerImpl(this, this.getController().getDifficultyLevel());
        this.colorGamaController.startGame();
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

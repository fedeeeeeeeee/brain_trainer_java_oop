package view.controllers.minigames.perilouspath;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import controller.minigames.perilouspath.PerilousPathController;
import controller.minigames.perilouspath.PerilousPathControllerImpl;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import timer.GameTimer;
import utility.Pair;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameController;

/**
 * Implementation of {@link PerilousPathFx}.
 */
public class PerilousPathFxImpl extends AbstractMiniGameController implements PerilouPathFx {

    /**
     * The Perilous Path's duration.
     */
    private static final int SECONDS = 31;

    /**
     * The size of the button.
     */
    private static final int BUTTON_SIZE = 100;

    private PerilousPathController controller;
    private Map<Button, Pair<Integer, Integer>> buttons;

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
        this.buttons = new HashMap<>();
        this.controller.startGame();
        this.setGameTimer(new GameTimer(SECONDS, this));
    }

    private EventHandler<MouseEvent> eventHandler = (e) -> {
        final Button bt = (Button) e.getSource();
        final Pair<Integer, Integer> position = this.buttons.get(bt);
        this.controller.hitAttempt(position.getX(), position.getY());
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawGrid(final int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final Button bt = new Button();
                bt.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
                bt.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
                this.grid.add(bt, j, i);
                this.buttons.put(bt, new Pair<>(i, j));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showStart(final Pair<Integer, Integer> start) {
        this.buttons.entrySet().stream()
                               .filter(bt -> bt.getValue().equals(start))
                               .forEach(bt -> bt.getKey().setText("START"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showFinish(final Pair<Integer, Integer> finish) {
        this.buttons.entrySet().stream()
                               .filter(bt -> bt.getValue().equals(finish))
                               .forEach(bt -> bt.getKey().setText("FINISH"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showMines(final Set<Pair<Integer, Integer>> mines) {
        this.buttons.entrySet().stream()
        .filter(bt -> mines.contains(bt.getValue()))
        .forEach(bt -> bt.getKey().setText("X"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showStep(final int row, final int col) {
        this.buttons.entrySet().stream()
                               .filter(bt -> bt.getValue().equals(new Pair<>(row, col)))
                               .forEach(bt -> bt.getKey().setStyle("-fx-background-color: rgb(158,61,100); -fx-border-color: darkred;"));
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
    @Override
    public void endGame(final int finalScore) {
        Platform.runLater(() -> {
            this.getController().updateProgress(finalScore);
            this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
        });
    }
}

package view.controllers.minigames.perilouspath;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;

import controller.minigames.perilouspath.PerilousPathController;
import controller.minigames.perilouspath.PerilousPathControllerImpl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
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
     * The duration dedicated to the memorization of the mines position.
     */
    private static final int MINE_SECONDS = 4;

    /**
     * The size of the button.
     */
    private static final int BUTTON_SIZE = 100;

    @FXML
    private VBox vBox;

    @FXML
    private GridPane grid;

    @FXML
    private Label instructions;

    @FXML
    private Label timerLbl;

    @FXML
    private ProgressBar progressBar;

    private PerilousPathController controller;
    private Map<Button, Pair<Integer, Integer>> buttons;
    private Timer secondaryTimer;
    private boolean timeFinish;
    private boolean lifeSecondaryTimer;

    private final EventHandler<MouseEvent> eventHit = (e) -> {
        final Button bt = (Button) e.getSource();
        final Pair<Integer, Integer> position = this.buttons.get(bt);
        this.controller.hitAttempt(position.getX(), position.getY());
    };

    private final EventHandler<ActionEvent> eventReset = (e) -> {
        this.buttons.entrySet().stream()
                               .forEach(bt -> bt.getKey().setDisable(false));
        this.controller.resetView();
    };

    private void animation() {
        final Timeline timeline = new Timeline();
        final KeyFrame keyFrame = new KeyFrame(Duration.millis(1000), eventReset);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.controller = new PerilousPathControllerImpl(this.getController().getDifficultyLevel(), this);
        this.buttons = new HashMap<>();
        this.controller.startGame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawGrid(final int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final Button bt = new Button();
                bt.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHit);
                bt.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
                bt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                this.grid.add(bt, j, i);
                this.buttons.put(bt, new Pair<>(i, j));
            }
        }
        this.vBox.setAlignment(Pos.CENTER);
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
    public void showExplosion(final int row, final int col) {
        this.buttons.entrySet().stream()
                               .filter(bt -> bt.getValue().equals(new Pair<>(row, col)))
                               .forEach(bt -> bt.getKey().setText("***"));
        this.buttons.entrySet().stream()
                               .forEach(bt -> bt.getKey().setDisable(true));
        this.animation();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void reset() {
        this.buttons.entrySet().stream().forEach(bt -> bt.getKey().setText(""));
        this.buttons.entrySet().stream().forEach(bt -> bt.getKey().setStyle(null));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startGameTimer() {
        this.setGameTimer(new GameTimer(SECONDS, this));
        this.timeFinish = false;
        this.lifeSecondaryTimer = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pauseGameTimer() {
        this.getGameTimer().pause();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void restartGameTimer() {
        this.getGameTimer().restart();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startSecondaryTimer() {
        this.secondaryTimer = new Timer();
        this.secondaryTimer.schedule(new GameTimer(MINE_SECONDS, this), 0, 1000);
        this.lifeSecondaryTimer = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateTimerView(final int second) {
        Platform.runLater(() -> {
            if (this.lifeSecondaryTimer) {
                this.instructions.setText("Memorize the mine's position");
            } else {
                this.instructions.setText("Find a safe path from start to finish");
                super.updateTimerView(second);
                if (second == 0) {
                    this.timeFinish = true;
                }
            }
            if (this.lifeSecondaryTimer && second == 0) {
                this.lifeSecondaryTimer = false;
                this.controller.secondaryTimerExpired();
            }
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeFinish() {
        if (this.timeFinish) {
            this.secondaryTimer.cancel();
            this.controller.timerExpired();
        }
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

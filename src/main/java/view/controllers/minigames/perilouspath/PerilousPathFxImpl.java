package view.controllers.minigames.perilouspath;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.DifficultyLevel;
import model.minigames.perilouspath.Mine;
import utility.Pair;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameControllerFx;

/**
 * Implementation of {@link PerilousPathFx}.
 */
public class PerilousPathFxImpl extends AbstractMiniGameControllerFx implements PerilousPathFx {

    /**
     * Mines memorization instruction.
     */
    private static final String MINES_MEMORIZATION_INSTRUCTION = "Memorize the position of the mines";

    /**
     * The instruction for the search of a safe path from start to finish.
     */
    private static final String PATH_INSTRUCTION = "Find a safe path from start to finish";

    /**
     * The instruction to show the perilous path chosen by the user.
     */
    private static final String PERILOUS_PATH_INSTRUCTION = "Perilous Path";

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
    private ProgressBar progressBar;

    private PerilousPathController controller;
    private Map<Button, Pair<Integer, Integer>> buttons;

    private final EventHandler<MouseEvent> eventHit = (e) -> {
        final Button bt = (Button) e.getSource();
        final Pair<Integer, Integer> position = this.buttons.get(bt);
        this.controller.hitAttempt(position.getX(), position.getY());
    };

    private final Function<String, ImageView> image = (imageName) -> {
        final ImageView image = new ImageView("/images/" + imageName + ".png");
        image.setFitHeight(BUTTON_SIZE / 2);
        image.setFitWidth(BUTTON_SIZE / 2);
        return image;
    };

    private final EventHandler<ActionEvent> eventReset = (e) -> {
        this.restore();
        this.controller.resetGame();
    };

    private final EventHandler<ActionEvent> eventUpdate = (e) -> {
        this.restore();
        this.instructions.setText(PATH_INSTRUCTION);
        this.controller.updateView();
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame(final DifficultyLevel difficultyLevel) {
        this.controller = new PerilousPathControllerImpl(difficultyLevel, this);
        this.buttons = new HashMap<>();
        this.progressBar.setStyle("-fx-accent: rgb(158,61,100)");
        this.controller.startGame();
        this.controller.startTimer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final int size) {
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
    public void animation(final int millis, final boolean mineExplosion) {
        final Timeline timeline = new Timeline();
        KeyFrame keyFrame;
        if (mineExplosion) {
            this.instructions.setText(PERILOUS_PATH_INSTRUCTION);
            keyFrame = new KeyFrame(Duration.millis(millis), eventReset);
        } else {
            this.instructions.setText(MINES_MEMORIZATION_INSTRUCTION);
            keyFrame = new KeyFrame(Duration.millis(millis), eventUpdate);
        }
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showStart(final Pair<Integer, Integer> start) {
        Objects.requireNonNull(start);
        this.buttons.entrySet().stream()
                               .filter(bt -> bt.getValue().equals(start))
                               .forEach(bt -> bt.getKey().setGraphic(image.apply("start")));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showFinish(final Pair<Integer, Integer> finish) {
        Objects.requireNonNull(finish);
        this.buttons.entrySet().stream()
                               .filter(bt -> bt.getValue().equals(finish))
                               .forEach(bt -> bt.getKey().setGraphic(image.apply("finish")));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showMines(final Set<Mine> mines) {
        Objects.requireNonNull(mines);
        mines.stream()
             .forEach(m -> this.buttons.entrySet().stream()
                                                  .filter(bt -> bt.getValue().equals(m.getMinePosition()))
                                                  .forEach(bt -> bt.getKey().setGraphic(image.apply("mine"))));
        this.buttons.entrySet().stream().forEach(bt -> bt.getKey().setDisable(true));
        this.buttons.entrySet().stream().forEach(bt -> bt.getKey().setStyle("-fx-opacity: 1"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showStep(final int row, final int col) {
        this.buttons.entrySet().stream().filter(bt -> bt.getValue().equals(new Pair<>(row, col))).forEach(
                bt -> bt.getKey().setStyle("-fx-background-color: rgb(158,61,100); -fx-border-color: darkred;"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showExplosion(final int row, final int col) {
        this.buttons.entrySet().stream()
                          .filter(bt -> bt.getValue().equals(new Pair<>(row, col)))
                          .forEach(bt -> bt.getKey().setGraphic(image.apply("bang")));
        this.buttons.entrySet().stream().forEach(bt -> bt.getKey().setDisable(true));
        this.buttons.entrySet().stream().forEach(bt -> bt.getKey().setStyle("-fx-opacity: 1"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void restore() {
        this.buttons.entrySet().stream().forEach(bt -> bt.getKey().setGraphic(null));
        this.buttons.entrySet().stream().forEach(bt -> bt.getKey().setDisable(false));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showEndGame(final int finalScore) {
        Platform.runLater(() -> {
            this.getController().updateProgress(finalScore);
            this.getView().loadProgress(SceneType.END_GAME.getFilePath());
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stopTimer() {
        this.controller.stopTimer();
    }
}

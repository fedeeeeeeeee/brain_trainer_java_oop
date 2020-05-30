package view.controllers.minigames.oneWay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.IntStream;

import controller.minigames.oneWay.OneWayController;
import controller.minigames.oneWay.SimpleOneWayController;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import model.minigames.oneWay.Direction;
import utility.Pair;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameControllerFx;

/**
 * The implementation of the {@link OneWayFx}.
 *
 */
public class OneWayFxImpl extends AbstractMiniGameControllerFx implements OneWayFx {

    private static final int IMG_DIM = 50;

    private static final String PLAY_GRID_BUTTON_BACKGROUND = "-fx-background-color: rgb(143,187,189)";
    private static final String GREEN = "-fx-border-color: #56b72d; -fx-border-width: 5px;";
    private static final String RED = "-fx-border-color: #ff0000; -fx-border-width: 5px;";
    private static final String BLUE = "-fx-accent: #49618C";

    private OneWayController controller;
    private Map<Button, Pair<Integer, Integer>> buttons;
    private List<Button> arrows;

    @FXML
    private Button play;

    @FXML
    private GridPane grid;

    @FXML
    private GridPane arrowRow;

    @FXML
    private GridPane outerGrid;

    @FXML
    private Label scoreLbl;

    @FXML
    private ProgressBar progressBar;

    private Button clickedBtn;
    private Button correctBtn;

    private final PauseTransition pause = new PauseTransition(Duration.seconds(0.4));
 //   private final PauseTransition finish = new PauseTransition(Duration.seconds(0.1));

    private final Function<String, ImageView> image = (path) -> {
        final ImageView image = new ImageView(path);
        image.setFitHeight(IMG_DIM);
        image.setFitWidth(IMG_DIM);
        return image;
    };

    private final EventHandler<MouseEvent> gridEventHandler = (e) -> {
        this.clickedBtn = (Button) e.getSource();
        this.controller.hit(buttons.get(clickedBtn).getX(), buttons.get(clickedBtn).getY());

        this.buttons.keySet().forEach(b -> {
            b.setDisable(true);
            b.setStyle("-fx-opacity: 1");
        });

        this.controller.showSolution();

        pause.setOnFinished(event -> {
            this.buttons.keySet().forEach(b -> b.setDisable(false));
            this.correctBtn.setStyle(null);
        });
        pause.playFromStart();

        this.controller.nextLevel();
    };

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.progressBar.setStyle(BLUE);
        this.controller = new SimpleOneWayController(this, this.getController().getDifficultyLevel());
        this.buttons = new HashMap<>();
        this.arrows = new ArrayList<>();
        this.controller.firstInit();
        this.controller.startTimer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawArrow(final List<Direction> steps) {
        // CHECK ARGS (CERCA CHECKANDRAISE METODO PROF
        IntStream.range(0, steps.size()).boxed().forEach(i -> {
            final Button btn = new Button();
            btn.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            this.arrowRow.add(btn, i, 0);
            this.arrows.add(btn);
            this.loadImage(i, steps.get(i));
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateArrows(final List<Direction> steps) {
        IntStream.range(0, steps.size()).boxed().forEach(i -> this.loadImage(i, steps.get(i)));
    }

    private void loadImage(final int idx, final Direction step) {
        this.arrows.get(idx).setGraphic(this.image.apply(step.getPath()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawGrid(final int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final Button btn = new Button();
                btn.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
                btn.addEventHandler(MouseEvent.MOUSE_CLICKED, gridEventHandler);
                this.grid.add(btn, j, i);
                this.buttons.put(btn, new Pair<>(i, j));
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateView(final Pair<Integer, Integer> initialPosition) {
        this.buttons.entrySet().stream()
                               .peek(e -> e.getKey().setGraphic(null))
                               .filter(bt -> bt.getValue().equals(initialPosition))
                               .forEach(bt -> {
                                        bt.getKey().setGraphic(this.image.apply("/images/start.png"));
                                        bt.getKey().setPadding(new Insets(-1, -1, -1, -1));
                                });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showCorrectAnswer(final Pair<Integer, Integer> finalPosition) {
        this.correctBtn = this.buttons.entrySet().stream()
                .filter(e -> e.getValue().getX() == finalPosition.getX() && e.getValue().getY() == finalPosition.getY())
                .map(x -> x.getKey()).findAny().get();
        this.correctBtn.setStyle(PLAY_GRID_BUTTON_BACKGROUND);
        this.correctBtn.setStyle(this.check(finalPosition) ? GREEN : RED);
    }

    // trova modo per farlo con predicate
    private boolean check(final Pair<Integer, Integer> finalPosition) {
        return this.buttons.get(clickedBtn).getX() == finalPosition.getX()
                && this.buttons.get(clickedBtn).getY() == finalPosition.getY();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showEndGame(final int finalScore) {
        Platform.runLater(() -> {
            this.scoreLbl.setText(Integer.toString(finalScore));
            this.getController().updateProgress(finalScore);
            this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
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

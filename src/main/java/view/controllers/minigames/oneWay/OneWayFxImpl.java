package view.controllers.minigames.oneWay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import controller.minigames.oneWay.OneWayController;
import controller.minigames.oneWay.SimpleOneWayController;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import model.minigames.oneWay.Direction;
import timer.GameTimer;
import utility.Pair;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameController;

public class OneWayFxImpl extends AbstractMiniGameController implements OneWayFx {

    private static final String GREEN = "-fx-border-color: #56b72d; -fx-border-width: 5px;";
    private static final String RED = "-fx-border-color: #ff0000; -fx-border-width: 5px;";
    private static final String BACKGROUND = "-fx-background-color: rgb(143,187,189)";
    private static final int SEC = 20;

    private OneWayController controller;
    private Map<Button, Pair<Integer, Integer>> buttons;
    private List<Button> arrows;

    private boolean isTimerStarted = false;

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

    private Button clickedBtn;
    private Button correctBtn;
    private final PauseTransition pause = new PauseTransition(Duration.seconds(0.5));

    private final EventHandler<MouseEvent> gridEventHandler = (e) -> {
        this.clickedBtn = (Button) e.getSource();
        this.controller.hit(buttons.get(clickedBtn).getX(), buttons.get(clickedBtn).getY());

        this.getGameTimer().pause();
        this.buttons.keySet().forEach(b -> {
            b.setDisable(true);
            b.setStyle("-fx-opacity: 1");
        });

        this.controller.showSolution();
        pause.setOnFinished(event -> {
            this.buttons.keySet().forEach(b -> b.setDisable(false));
            correctBtn.setStyle(null);
        });
        pause.play();

        this.getGameTimer().restart();
        this.controller.nextLevel();
    };

    @Override
    public void initGame() {
        this.controller = new SimpleOneWayController(this, this.getController().getDifficultyLevel());
        this.buttons = new HashMap<>();
        this.arrows = new ArrayList<>();
        this.controller.firstInit();
        this.startTimer(SEC);
    }

    private void startTimer(int sec) {
        if (!isTimerStarted) {
            this.setGameTimer(new GameTimer(sec, this));
        }
        this.isTimerStarted = true;
    }

    @Override
    public void drawArrow(final List<Direction> steps) {
        for (int i = 0; i < steps.size(); i++) {
            final Button btn = new Button();
            btn.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
            this.arrowRow.add(btn, i, 0);
            this.arrows.add(btn);
            this.loadImages(i, steps);
        }
    }

    @Override
    public void updateArrows(final List<Direction> steps) {
        for (int i = 0; i < steps.size(); i++) {
            this.loadImages(i, steps);
        }
    }

    private void loadImages(int idx, final List<Direction> steps) {
        final String txt = steps.get(idx).toString();
        Direction direction = Arrays.asList(Direction.values()).stream().filter(d -> d.toString().equals(txt))
                .findFirst().get();

        ImageView img = new ImageView(direction.getPath());
        img.setFitHeight(50);
        img.setFitWidth(50);
        this.arrows.get(idx).setGraphic(img);
    }

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

    @Override
    public void updateView(final Pair<Integer, Integer> initialPosition) {
        for (Entry<Button, Pair<Integer, Integer>> entry : this.buttons.entrySet()) {
            entry.getKey().setText(initialPosition.equals(entry.getValue()) ? "Start" : "");
        }
    }

    @Override
    public void timeFinish() {
        this.controller.timeExpired();
    }

    @Override
    public void showScore(final int finalScore) {
        Platform.runLater(() -> {
            this.scoreLbl.setText(Integer.toString(finalScore));
            this.getController().updateProgress(finalScore);
            this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
        });
    }

    @Override
    public void showCorrectAnswer(final Pair<Integer, Integer> finalPosition) {
        this.correctBtn = this.buttons.entrySet().stream()
                .filter(e -> e.getValue().getX() == finalPosition.getX() && e.getValue().getY() == finalPosition.getY())
                .map(x -> x.getKey()).findAny().get();

        correctBtn.setStyle(BACKGROUND);
        this.correctBtn.setStyle(check(finalPosition) ? GREEN : RED);
    }

    private boolean check(final Pair<Integer, Integer> finalPosition) {
        return this.buttons.get(clickedBtn).getX() == finalPosition.getX()
                && this.buttons.get(clickedBtn).getY() == finalPosition.getY();
    }

}

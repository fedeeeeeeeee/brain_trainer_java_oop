package view.controllers.minigames.oneWay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import controller.minigames.oneWay.OneWayController;
import controller.minigames.oneWay.SimpleOneWayController;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.minigames.oneWay.Direction;
import timer.GameTimer;
import utility.Pair;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameController;

public class OneWayFx extends AbstractMiniGameController {

    private static final int SEC = 10;
    private static final int BUTTON_SIZE = 100;

    private OneWayController controller;
    private Map<Button, Pair<Integer, Integer>> buttons;
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

    private final EventHandler<MouseEvent> gridEventHandler = (e) -> {
        final Button btn = (Button) e.getSource();
        this.controller.hit(buttons.get(btn).getX(), buttons.get(btn).getY());

    }; 

    @Override
    public void initGame() {
        this.controller = new SimpleOneWayController(this, this.getController().getDifficultyLevel());
        this.buttons = new HashMap<>();
        this.controller.start();

        if (!isTimerStarted) {
            this.setGameTimer(new GameTimer(SEC, this));
        }
        this.isTimerStarted = true;
    }


    public void drawArrow(final List<Direction> steps) {
        for (int x = 0; x < steps.size(); x++) {
            final String txt = steps.get(x).toString();
            final Button bt = new Button();
            bt.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
            this.arrowRow.add(bt, x, 0);

            Direction direction = Arrays.asList(Direction.values()).stream().filter(d -> d.toString().equals(txt))
                    .findFirst().get();

            ImageView img = new ImageView(direction.getPath());
            img.setFitHeight(50);
            img.setFitWidth(50);
            bt.setGraphic(img);
        }
    }

    public void drawGrid(final int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final Button btn = new Button();
                btn.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
                btn.addEventHandler(MouseEvent.MOUSE_CLICKED, gridEventHandler);
                this.grid.add(btn, j, i);
                this.buttons.put(btn, new Pair<>(i, j));
            }
        }
    }

    public void updateView(final Pair<Integer, Integer> initialPosition) {
        for (Entry<Button, Pair<Integer, Integer>> entry : this.buttons.entrySet()) {
            entry.getKey().setText(initialPosition.equals(entry.getValue()) ? "START" : "");
        }
    }

    @Override
    public void timeFinish() {
        this.controller.timeExpired();
    }

    public void showScore(final int finalScore) {
        Platform.runLater(() -> {
            this.scoreLbl.setText(Integer.toString(finalScore));
            this.getController().updateProgress(finalScore);
            this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
        });
    }

}
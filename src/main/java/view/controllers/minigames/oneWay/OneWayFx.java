package view.controllers.minigames.oneWay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import controller.minigames.oneWay.OneWayController;
import controller.minigames.oneWay.OneWayControllerWithShuffle;
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
    private final Map<Button, Pair<Integer, Integer>> buttons = new HashMap<>();
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

    @Override
    public void initGame() {

        switch (this.getController().getArea()) {
        case MEMORY:
            this.controller = new OneWayControllerWithShuffle(this, this.getController().getDifficultyLevel());
            break;
        case BRAIN_SPEED:
            this.controller = new SimpleOneWayController(this, this.getController().getDifficultyLevel());
            break;
        default:
            break;
        }

        this.drawGrid();
        this.drawArrow();
        this.updateView();
        if (!isTimerStarted) {
            this.setGameTimer(new GameTimer(SEC, this));
        }
        this.isTimerStarted = true;
    }
    
    EventHandler<MouseEvent> gridEventHandler = (e) -> {
        final Button btn = (Button) e.getSource();
        this.controller.hit(buttons.get(btn).getX(), buttons.get(btn).getY());

        // NON VA BENE PERCHE CREO BOTTONI UNO SOPRA L'ALTRO AD OGNI CLICK--> ridisegna
        // le frrecce
//        this.initGame();  
    };

    private void drawArrow() {
        for (int x = 0; x < controller.getSteps().size(); x++) {
            final String txt = controller.getSteps().get(x).toString();
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

    private void drawGrid() {
        for (int i = 0; i < controller.getSize(); i++) {
            for (int j = 0; j < controller.getSize(); j++) {
                final Button btn = new Button();
                btn.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
                btn.addEventHandler(MouseEvent.MOUSE_CLICKED, gridEventHandler);
                this.grid.add(btn, j, i);
                this.buttons.put(btn, new Pair<>(i, j));
            }
        }
    }

    private void updateView() {
        Pair<Integer, Integer> initialPos = this.controller.getInitialPos();
        for (Entry<Button, Pair<Integer, Integer>> entry : this.buttons.entrySet()) {
            entry.getKey().setText(initialPos.equals(entry.getValue()) ? "START" : "");
        }
    }

    @Override
    public void timeFinish() {
        this.controller.expiredTime();
    }

    public void showScore(int finalScore) {
        Platform.runLater(() -> {
            this.scoreLbl.setText(Integer.toString(finalScore));
            this.getController().updateProgress(finalScore);
            this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
        });
    }
    
}
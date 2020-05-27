package view.controllers.minigames.sizecount;

import java.util.LinkedList;
import java.util.List;

import controller.minigames.sizecounts.SizeCountController;
import controller.minigames.sizecounts.SizeCountControllerImpl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.minigames.sizecount.IntegerOperation;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameControllerFx;

public class SizeCountFxImpl extends AbstractMiniGameControllerFx implements SizeCountFx {

    /**
     * The width of the button that make up the view.
     */
    private static final int WIDTH = 333;

    private SizeCountController controller;
    private List<Button> buttons;
    private Button currentAnswer;

    @FXML
    private VBox panel;

    private final EventHandler<ActionEvent> event = (e) -> {
        this.currentAnswer.setStyle("-fx-font-size: 20; -fx-border-color: #000000; -fx-border-width: 0.1px;");
    };

    private void animation() {
        final Timeline timeline = new Timeline();
        final KeyFrame kf = new KeyFrame(Duration.millis(300), event);
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.buttons = new LinkedList<>();
        this.controller = new SizeCountControllerImpl(this);
        this.controller.startTimer();
        this.controller.resetGame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final List<IntegerOperation> operations) {
        for (int i = 0; i < operations.size(); i++) {
            final Button bt = this.buttons.get(i);
            bt.setText(operations.get(i).toString());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOperations(final Integer numOperations) {
        final EventHandler<MouseEvent> ev = (e) -> {
            final Button bt = (Button) e.getSource();
            this.currentAnswer = bt;
            this.controller.newAttempt(bt.getText());
        };
        for (int i = 0; i < numOperations; i++) {
            final Button bt = new Button();
            bt.setStyle("-fx-font-size: 20");
            // bt.setMinSize(bt.USE_COMPUTED_SIZE, bt.USE_COMPUTED_SIZE);
            bt.setPrefWidth(WIDTH);
            this.buttons.add(bt);
            bt.addEventHandler(MouseEvent.MOUSE_CLICKED, ev);
            this.panel.getChildren().add(bt);
        }
        final Button same = new Button("SAME");
        same.setStyle("-fx-font-size: 20");
        // same.setMinSize(same.USE_COMPUTED_SIZE, same.USE_COMPUTED_SIZE);
        same.setPrefWidth(WIDTH);
        same.addEventHandler(MouseEvent.MOUSE_CLICKED, ev);
        this.panel.getChildren().add(same);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showWrongAnswer() {
        this.currentAnswer.setStyle("-fx-font-size: 20;-fx-border-color:#FF0000 ; -fx-border-width: 2px;");
        this.animation();
        this.controller.resetGame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showCorrectAnswer() {
        this.currentAnswer.setStyle("-fx-font-size: 20; -fx-border-color:#66FF66 ; -fx-border-width: 2px;");
        this.animation();
        this.controller.resetGame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showEndGame(final int score) {
        Platform.runLater(() -> {
            this.getController().updateProgress(score);
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

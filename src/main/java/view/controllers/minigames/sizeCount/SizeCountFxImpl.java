package view.controllers.minigames.sizeCount;

import java.util.LinkedList;
import java.util.List;

import controller.minigames.sizeCounts.SizeCountController;
import controller.minigames.sizeCounts.SizeCountControllerImpl;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.minigames.sizeCount.IntegerOperation;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameController;

public class SizeCountFxImpl extends AbstractMiniGameController implements SizeCountFx {

    private SizeCountController controller;
    private List<Button> buttons;
    private Button currentAnswer;
    private Button same;

    @FXML
    private VBox panel;

    @Override
    public void timeFinish() {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.buttons = new LinkedList<>();
        this.controller = new SizeCountControllerImpl(this);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void draw(final List<IntegerOperation> operations) {
        for (int i = 0; i < operations.size(); i++) {
            this.buttons.get(i).setText(operations.get(i).toString());
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOperations(final Integer numOperations) {
        EventHandler<MouseEvent> ev = (e) -> {
            final Button bt = (Button) e.getSource();
            this.currentAnswer = bt;
            this.controller.newAttempt(bt.getText());
        };
        for (int i = 0; i < numOperations; i++) {
            final Button bt = new Button();
            this.buttons.add(bt);
            bt.addEventHandler(MouseEvent.MOUSE_CLICKED, ev);
            this.panel.getChildren().add(bt);
        }

        this.same = new Button("SAME");
        this.same.addEventHandler(MouseEvent.MOUSE_CLICKED, ev);
        this.panel.getChildren().add(this.same);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showWrongAnswer() {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showCorrectAnswer() {
        // TODO Auto-generated method stub

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

}

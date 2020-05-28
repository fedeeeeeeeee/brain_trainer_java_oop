package view.controllers.minigames.colorgama;

import org.apache.commons.lang3.tuple.Triple;

import controller.minigames.colorgama.ColorGamaController;
import controller.minigames.colorgama.ColorGamaControllerImpl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import model.minigames.colorgama.ComputeColor;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameControllerFx;

/**
 * This class implements {@link ColorGamaFx}.
 *
 */
public class ColorGamaFxImpl extends AbstractMiniGameControllerFx implements ColorGamaFx {

    private static final int BT_SIZE = 300;

    private static final double MILLIS = 300;

    @FXML
    private GridPane buttonsGrid;

    @FXML
    private ImageView image;

    @FXML
    private Label questionTitle;

    @FXML
    private Label questionColor;

    private ColorGamaController colorGamaController;

    private final EventHandler<MouseEvent> eventHandler = (l) -> {
        final Button bt = (Button) l.getSource();
        this.colorGamaController.checkAnswer(this.buttonsGrid.getChildren().indexOf(bt));
    };

    private final EventHandler<ActionEvent> rightEvent = (l) -> {
        this.image.setVisible(false);
        this.colorGamaController.next();
    };

    private final EventHandler<ActionEvent> wrongEvent = (l) -> this.image.setVisible(false);

    private void setImage(final String imagePath) {
        this.image.setVisible(true);
        this.image.setImage(new Image(imagePath, true));
    }

    private void showAnimation(final boolean isRight) {
        final Timeline timeline = new Timeline();
        final KeyFrame frame = isRight ? new KeyFrame(Duration.millis(MILLIS), rightEvent) : new KeyFrame(Duration.millis(MILLIS), wrongEvent);
        timeline.getKeyFrames().add(frame);
        timeline.play();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.colorGamaController = new ColorGamaControllerImpl(this, this.getController().getDifficultyLevel());
        this.colorGamaController.startTimer();
        this.colorGamaController.startGame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGrid(final int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final Button bt = new Button();
                bt.setPrefSize(BT_SIZE, BT_SIZE);
                bt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                bt.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
                buttonsGrid.add(bt, i, j);
            }
        }
    }

    /**
     * {@inheritDoc}
     * 
     */
    @Override
    public void renderNext(final ComputeColor computeColor, final String questionSentence) {
        this.buttonsGrid.getChildren().forEach((b) -> {
            final Triple<Integer, Double, Double> color = computeColor.nextColorValues();
            ((Button) b).setBackground(new Background(new BackgroundFill(Color.hsb(color.getLeft(), color.getMiddle(), color.getRight()), new CornerRadii(2), new Insets(2))));
        });
        this.questionTitle.setText(questionSentence);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRightColor(final int index, final Triple<Integer, Double, Double> triple) {
        ((Button) this.buttonsGrid.getChildren().get(index)).setBackground(new Background(new BackgroundFill(Color.hsb(triple.getLeft(), triple.getMiddle(), triple.getRight()), new CornerRadii(2), new Insets(2))));
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void showQuestionColor(final Integer hue, final Double saturation, final Double brightness) {
        this.questionColor.setVisible(true);
        this.questionColor.setBackground(new Background(new BackgroundFill(Color.hsb(hue, saturation, brightness), new CornerRadii(2), new Insets(2))));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hideQuestionColor() {
        this.questionColor.setVisible(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rightAnswer() {
        this.setImage("/images/tick.png");
        this.showAnimation(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void wrongAnswer() {
        this.setImage("/images/cross.png");
        this.showAnimation(false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showEndGame(final int finalScore) {
        Platform.runLater(() -> {
            this.getController().updateProgress(finalScore);
            this.getView().setHandleDataScene(SceneType.END_GAME.getFilePath());
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void stopTimer() {
        this.colorGamaController.stopTimer();
    }

}

package view.controllers.minigames.colorgama;

import org.apache.commons.lang3.tuple.Triple;

import controller.minigames.colorgama.ColorGamaController;
import controller.minigames.colorgama.ColorGamaControllerImpl;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.minigames.colorgama.ComputeColor;
import timer.GameTimer;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameController;

/**
 * This class implements {@link ColorGamaFx}.
 *
 */
public class ColorGamaFxImpl extends AbstractMiniGameController implements ColorGamaFx {

    private static final int SECONDS = 30;
    private static final int BT_SIZE = 300;

    @FXML
    private GridPane buttonsGrid;

    @FXML
    private ImageView image;

    private ColorGamaController colorGamaController;
    private final EventHandler<MouseEvent> eventHandler = (l) -> {
        final Button bt = (Button) l.getSource();
        this.colorGamaController.checkAnswer(this.buttonsGrid.getChildren().indexOf(bt));
    };

    private void setImage(final String imagePath) {
        this.image.setImage(new Image(imagePath, true));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void drawGrid(final int size, final ComputeColor colors) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final Button bt = new Button();
                final Triple<Integer, Double, Double> color = colors.nextColorValues();
                bt.setPrefSize(BT_SIZE, BT_SIZE);
                bt.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                bt.addEventHandler(MouseEvent.MOUSE_CLICKED, eventHandler);
                bt.setBackground(new Background(new BackgroundFill(Color.hsb(color.getLeft(), color.getMiddle(), color.getRight()), new CornerRadii(2), new Insets(2))));
                buttonsGrid.add(bt, i, j);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initGame() {
        this.colorGamaController = new ColorGamaControllerImpl(this, this.getController().getDifficultyLevel());
        this.colorGamaController.startGame();
        this.setGameTimer(new GameTimer(SECONDS, this)); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timeFinish() {
       this.colorGamaController.timeExpired();
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void showNext(final ComputeColor computeColor) {
        this.buttonsGrid.getChildren().forEach((b) -> {
            final Triple<Integer, Double, Double> color = computeColor.nextColorValues();
            ((Button) b).setBackground(new Background(new BackgroundFill(Color.hsb(color.getLeft(), color.getMiddle(), color.getRight()), new CornerRadii(2), new Insets(2))));
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rightAnswer() {
        this.setImage("/images/tick.png");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void wrongAnswer() {
        this.setImage("/images/cross.png");
    }

}

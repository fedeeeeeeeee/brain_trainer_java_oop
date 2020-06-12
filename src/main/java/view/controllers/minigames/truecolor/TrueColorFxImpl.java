package view.controllers.minigames.truecolor;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import controller.minigames.truecolor.TrueColorController;
import controller.minigames.truecolor.TrueColorControllerImpl;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;
import model.minigames.truecolor.Colors;
import utility.Pair;
import view.SceneType;
import view.controllers.minigames.AbstractMiniGameControllerFx;

/**
 * Represents the True Color View.
 */
public class TrueColorFxImpl extends AbstractMiniGameControllerFx implements TrueColorFx {

    private static final String TXTFILL = "-fx-text-fill: ";
    private static final String BACKGROUND = "-fx-background-color: ";
    private static final String BORDERC = "-fx-border-color: ";
    private static final String BORDERW = "-fx-border-width: ";
    private static final String RADIUS = "-fx-background-radius: ";
    private static final String MEANCOLOR = "randomMeaningColor";
    private static final String TRUECOLOR = "randomTrueColor";
    private static final int SHADOWX = 4;
    private static final int SHADOWY = 6;
    private static final int FONT = 35;
    private static final int SIZE_BUTTON = 300;
    private TrueColorController trueColorController;
    private List<Button> meaningColorBtnList;
    private List<Button> trueColorBtnList;
    private int meanColorSize;
    private int trueColorSize;
    private Button currentAnswer;
    private final DropShadow shadow = new DropShadow();

    @FXML
    private VBox vBoxId;

    private final EventHandler<ActionEvent> event = (e) -> {
        this.currentAnswer.setStyle(BORDERC + "#000000;" + BORDERW + "0.3px;");
    };

    @FXML
    private void buttonClicked(final MouseEvent event) throws IOException { // NOPMD
        final String selectedAnswer = ((Button) event.getSource()).getText();
        this.currentAnswer = (Button) event.getSource();
        this.trueColorController.check(selectedAnswer);
    }

    private void setDropShadow() {
        this.shadow.setOffsetX(SHADOWX);
        this.shadow.setOffsetY(SHADOWY);
    }

    private void setStyleButton(final List<Pair<Colors, Colors>> listColor, final List<Button> listBtn) {
        Objects.requireNonNull(listColor);
        Objects.requireNonNull(listBtn);
        final int size = listBtn.size();
        for (int i = 0; i < size; i++) {
            listBtn.get(i).setText(listColor.get(i).getX().toString());
            listBtn.get(i).setStyle(TXTFILL + listColor.get(i).getY().getName() + ";" + RADIUS + "5em");
            listBtn.get(i).setFont(Font.font(FONT));
            if (this.meaningColorBtnList == listBtn) {
                listBtn.get(i).setEffect(this.shadow);
            }
        }
    }

    private void prepareButtons() {
        this.meaningColorBtnList = new LinkedList<>();
        this.trueColorBtnList = new LinkedList<>();
        this.addButton(this.meaningColorBtnList, this.meanColorSize);
        this.addButton(this.trueColorBtnList, this.trueColorSize);
    }

    private void addButton(final List<Button> btnList, final Integer size) {
        for (int i = 0; i < size; i++) {
            final Button button = new Button();
            button.setPrefSize(SIZE_BUTTON, SIZE_BUTTON / 3);
            btnList.add(button);
            this.vBoxId.getChildren().add(button);
        }
    }
 
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
        this.trueColorController = new TrueColorControllerImpl(this.getController().getDifficultyLevel(), this);
        this.setDropShadow();
        this.prepareButtons();
        this.trueColorController.startTimer();
        this.trueColorController.startGame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void next() {
        this.trueColorController.refresh();
        this.trueColorController.startGame();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setButtons(final Map<String, List<Pair<Colors, Colors>>> colorMap) {
        Objects.requireNonNull(colorMap, "Map of Random Color is null");
        this.setStyleButton(colorMap.get(MEANCOLOR), this.meaningColorBtnList);
        this.setStyleButton(colorMap.get(TRUECOLOR), this.trueColorBtnList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void alternativeSetButton(final List<Pair<Colors, Colors>> list) {
        Objects.requireNonNull(list);
        final int size = this.trueColorBtnList.size();
        for (int i = 0; i < size; i++) {
            this.trueColorBtnList.get(i).setText("");
            this.trueColorBtnList.get(i).setStyle(BACKGROUND + list.get(i).getY().getName());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSizeBtnList(final Map<String, List<Pair<Colors, Colors>>> colorMap) {
        this.meanColorSize = colorMap.get(MEANCOLOR).size();
        this.trueColorSize = colorMap.get(TRUECOLOR).size();
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
        this.trueColorController.stopTimer();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void showAnswer(final boolean bool) {
        this.currentAnswer.setStyle(BORDERW + "2px;" + BORDERC + (bool ? "#66FF66" : "#FF0000"));
        this.animation();
    }
}

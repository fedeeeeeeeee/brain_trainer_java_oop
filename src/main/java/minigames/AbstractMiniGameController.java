
package minigames;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.DifficultyLevel;
import model.score.ScoreModel;
import model.score.ScoreModelImpl;
import timer.EventTimer;

/**
 * This abstract class implements the common aspect of MiniGameControllers.
 *
 */
public abstract class AbstractMiniGameController implements MiniGameController {

    @FXML
    private Label timerLbl;

    @FXML
    private Label score;

    private final ScoreModel scoreModel;

    public AbstractMiniGameController(final DifficultyLevel difficulty, final int basePoint) {
        this.scoreModel = new ScoreModelImpl(difficulty, basePoint);

    }

    public final ScoreModel getScoreModel() {
        return this.scoreModel;
    }

    @Override
    public final void updateTimerView(final EventTimer eventTimer) {
        Platform.runLater(() -> this.timerLbl.setText(Integer.toString(eventTimer.getValue())));
        if (eventTimer.getValue() == 0) {
            Platform.runLater(() -> {
//                System.out.println("Exit Game");
                this.score.setText(Integer.toString(this.scoreModel.getScore()));
                // System.exit(0);
            });
        }
    }
}

package minigames;

import java.util.Timer;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import timer.EventTimer;
import timer.GameTimer;

/**
 * This abstract class implements the common aspect of {@link MiniGameController}.
 *
 */
public abstract class AbstractMiniGameController implements MiniGameController {

    @FXML
    private Label timerLbl;

    private Timer timer;
    private GameTimer gameTimer;

    /**
     * Simple constructor of AbstractMiniGameController.
     */
    public AbstractMiniGameController() {
        this.timer = new Timer();
    }

    /**
     * Sets the field gameTimer.
     * 
     * @param gameTimer
     */
    protected void setGameTimer(final GameTimer gameTimer) {
        this.gameTimer = gameTimer;
        this.timer.schedule(this.gameTimer, 0, 1000);
    }

    /**
     * @return 
     *        the field gameTimer
     * 
     */
    protected GameTimer getGameTimer() {
        return this.gameTimer;
    }

    @Override
    public final void updateTimerView(final EventTimer eventTimer) {
        Platform.runLater(() -> this.timerLbl.setText(Integer.toString(eventTimer.getValue())));
    }

}


package minigames;

import java.util.Timer;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import timer.GameTimer;

/**
 * This abstract class implements the common aspect of {@link MiniGameController}.
 *
 */
public abstract class AbstractMiniGameController implements MiniGameController {

    @FXML
    private Label timerLbl;

    @FXML
    private ProgressBar progressBar;

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

    /**
     *  {@inheritDoc}
     */
    @Override
    public void updateTimerView(final int second) {
        Platform.runLater(() -> {
            this.timerLbl.setText(Integer.toString(second));
            this.progressBar.setProgress((double) second / this.gameTimer.getInitialSeconds());
        });
    }

}

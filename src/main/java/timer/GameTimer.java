
package timer;

import java.util.TimerTask;

import minigames.MiniGameController;

/**
 * 
 * This class implements {@link GameTimer}.
 *
 */
public class GameTimer extends TimerTask {

    private int seconds;
    private MiniGameController miniGameController;
    private TimeFlow time;
    private boolean stop;

    /**
     * Constructor of GameTimerImpl.
     * 
     * @param seconds
     * @param miniGameController
     */
    public GameTimer(final int seconds, final MiniGameController miniGameController) {
        this.seconds = seconds;
        this.miniGameController = miniGameController;
        this.time = (s -> s - 1);
        this.stop = false;
    }

    private void notifyChange(final EventTimer eventTimer) {
        this.miniGameController.updateTimerView(eventTimer);
    }

    /**
     * Pause the timer flow.
     */
    public void pause() {
        this.stop = true;
    }

    /**
     *  Restart the timer previously paused.
     */
    public void restart() {
        this.stop = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
       if (this.seconds > 0 && !this.stop) {
           this.seconds =  this.time.timeFlow(this.seconds);
           this.notifyChange(new EventTimerImpl(this.seconds));
       }
    }
}
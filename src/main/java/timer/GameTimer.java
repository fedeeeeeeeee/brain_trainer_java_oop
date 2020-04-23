
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
    }

    private void notifyChange(final EventTimer eventTimer) {
        this.miniGameController.updateTimerView(eventTimer);
    }

    /**
     * Pause the timer flow.
     */
    public void pause() {
        // TODO Auto-generated method stub
    }

    /**
     *  Restart the timer previously paused.
     */
    public void restart() {
        // TODO Auto-generated method stub
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() {
       if (this.seconds > 0) {
           this.seconds =  this.time.timeFlow(this.seconds);
           this.notifyChange(new EventTimerImpl(this.seconds));
       }
    }
}
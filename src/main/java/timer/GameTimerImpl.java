
package timer;

import java.util.TimerTask;

import minigames.MiniGameController;

/**
 * 
 * This class implements {@link GameTimer}.
 *
 */
public class GameTimerImpl extends TimerTask implements GameTimer {

    private int seconds;
    private MiniGameController miniGameController;

    /**
     * Constructor of GameTimerImpl.
     * 
     * @param seconds
     * @param miniGameController
     */
    public GameTimerImpl(final int seconds, final MiniGameController miniGameController) {
        this.seconds = seconds;
        this.miniGameController = miniGameController;
    }

    private void notifyChange(final EventTimer eventTimer) {
        this.miniGameController.updateTimerView(eventTimer);
    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub
    }

    @Override
    public void restart() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
    }
}
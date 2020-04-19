
package timer;

import minigames.MiniGameController;

/**
 * 
 * This class implements {@link GameTimer}.
 *
 */
public class GameTimerImpl implements GameTimer {

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
    public final void decrement() {
        this.seconds = this.seconds - 1;
        this.notifyChange(new EventTimerImpl(this.seconds));
    }
}
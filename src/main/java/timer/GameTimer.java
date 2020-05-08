
package timer;

import java.util.TimerTask;
import java.util.function.Function;

import minigames.FxMiniGameController;

/**
 * 
 * This class represents the timer of minigames.
 *
 */
public class GameTimer extends TimerTask {

    private int initialSeconds;
    private int seconds;
    private final FxMiniGameController controller;
    private final Function<Integer, Integer> timeFlow;
    private boolean stop;

    /**
     * Constructor of GameTimerImpl.
     * 
     * @param seconds
     * @param controller
     */
    public GameTimer(final int seconds, final FxMiniGameController controller) {
        this.initialSeconds = seconds;
        this.seconds = seconds;
        this.controller = controller;
        this.timeFlow = s -> s - 1;
        this.stop = false;
    }

    private void notifyChange() throws OverTimeException {
        if (this.seconds >= 0) {
            this.controller.updateTimerView(this.seconds);
        } else {
            this.cancel();
            throw new OverTimeException();
        }
    }

    /**
     * Get initial seconds.
     * 
     * @return
     *             seconds
     */
    public int getInitialSeconds() {
        return this.initialSeconds;
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
        if (!this.stop) {
            this.seconds = this.timeFlow.apply(this.seconds);
            try {
                this.notifyChange();
            } catch (OverTimeException e) {
                this.controller.timeFinish();
            }
        }
    }
}

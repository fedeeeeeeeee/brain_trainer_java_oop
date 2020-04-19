
package timer;

import minigames.MiniGameController;

/**
 * 
 * This class implements an AgentTimer and extends Thread.
 *
 */
public class AgentTimer extends Thread {

    private MiniGameController miniGameController;
    private boolean timeFinish;
    private GameTimer timer;

    /**
     * Constructor of AgentTimer.
     * 
     * @param miniGameController
     * 
     */
    public AgentTimer(final MiniGameController miniGameController) {
        this.miniGameController = miniGameController;
        this.timeFinish = false;
    }

    /**
     * Set the seconds of the GameTimer.
     * 
     * @param seconds
     */
    public void setTime(final int seconds) {
        this.timer = new GameTimerImpl(seconds, this.miniGameController);
    }

    /**
     * Stop the flow of the GameTimer.
     */
    public void stopTimer() {
        super.interrupt();
        this.timeFinish = true;
    }

    @Override
    public final void run() {
        while (!this.timeFinish) {
            try {
                this.timer.decrement();
                super.sleep(1000);
            } catch (InterruptedException e) {
                // e.printStackTrace();
            }
        }
    }
}

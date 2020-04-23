
package timer;

/**
 * This interface models a timer that tracks the elapsed time.
 */
public interface GameTimer {
    /**
     * Pause the timer flow.
     */
    void pause();

    /**
     *  Restart the timer previously paused.
     */
    void restart();

}

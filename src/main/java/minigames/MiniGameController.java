
package minigames;

import timer.EventTimer;

/**
 * 
 * This interface represents the common parts of
 * the minigame view.
 *
 */
public interface MiniGameController {

    /**
     * Update the seconds of the timer on the view.
     * 
     * @param eventTimer
     */
    void updateTimerView(EventTimer eventTimer);

    /**
     * Indicates that the time available is finished.
     */
    void timeFinsh();
}


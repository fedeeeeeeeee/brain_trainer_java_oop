
package minigames;

import timer.EventTimer;

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

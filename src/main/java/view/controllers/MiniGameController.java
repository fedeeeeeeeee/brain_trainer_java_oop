package view.controllers;

import timer.EventTimer;

public interface MiniGameController {
	
	/**
	 * update the seconds of the timer on the view
	 * 
	 * @param eventTimer
	 */
	void updateTimerView(final EventTimer eventTimer);

}

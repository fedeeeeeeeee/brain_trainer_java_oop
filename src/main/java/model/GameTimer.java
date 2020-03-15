package model;

/**
 * This interface models a timer that tracks the elapsed time
 */
public interface GameTimer {
	/**
	 * Start the timer counter
	 * 
	 * @param seconds
	 * 				
	 */
	void start();
	
	/**
	 * @return 
	 * 			true if the time is finished, false otherwise
	 */
	boolean isTimeFinished();
}

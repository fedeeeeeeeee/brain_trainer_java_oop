package model;

/**
 * This interface models a timer that tracks the elapsed time
 */
public interface Timer {
	/**
	 * Start the timer counter
	 * 
	 * @param seconds
	 * 				
	 */
	void start(final int seconds);
	
	/**
	 * @return 
	 * 			true if the time is finished, false otherwise
	 */
	boolean isTimeFinished();
}

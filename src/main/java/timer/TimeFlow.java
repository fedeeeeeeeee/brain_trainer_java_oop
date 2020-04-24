package timer;

/**
 * 
 * This functional interface represents the time flow of a Timer. 
 *
 */
@FunctionalInterface
public interface TimeFlow {

    /**
     * Calculate the time flow.
     * 
     * @param seconds
     * @return
     *          the seconds results
     */
    int timeFlow(int seconds);

}

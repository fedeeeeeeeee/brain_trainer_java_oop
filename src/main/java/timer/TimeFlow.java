package timer;

/**
 * 
 * This functional interface represents the time flow of a Timer. 
 *
 */
@FunctionalInterface
public interface TimeFlow {
    int timeFlow(int seconds);

}

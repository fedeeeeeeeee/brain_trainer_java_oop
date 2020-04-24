
package timer;

/**
 * 
 * This class implements {@link EventTimer} that keeps trace
 * of the current value of seconds.
 *
 */
public final class EventTimerImpl implements EventTimer {

    private final int currentValue;

    /**
     * Simple constructor of EventTimerImpl.
     * 
     * @param currentValue
     *          the value of seconds
     */
    public EventTimerImpl(final int currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public int getValue() {
        return this.currentValue;
    }
}

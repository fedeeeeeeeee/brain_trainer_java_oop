package timer;

public class EventTimerImpl implements EventTimer {

	private int currentValue;
	
	
	
	public EventTimerImpl(final int currentValue) {
		this.currentValue = currentValue;
	}



	@Override
	public int getValue() {
		return this.currentValue;
	}

}

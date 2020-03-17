package timer;

import view.controllers.MiniGameController;

public class GameTimerImpl implements GameTimer {

	private int seconds;
	private MiniGameController miniGameController;
	
	public GameTimerImpl(final int seconds, final MiniGameController miniGameController) {
		this.seconds = seconds;
		this.miniGameController = miniGameController;
	}


	private void  notifyChange (final EventTimer eventTimer) {
		this.miniGameController.updateTimerView(eventTimer);
	}

	@Override
	public void decrement() {
		this.seconds = this.seconds - 1;
		this.notifyChange(new EventTimerImpl(this.seconds));
		
	}
	
	

}

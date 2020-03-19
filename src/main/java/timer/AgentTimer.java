package timer;

import view.controllers.MiniGameController;

public class AgentTimer extends Thread {
	
	private MiniGameController miniGameController;
	private volatile boolean timeFinish;
	private volatile GameTimer timer;
	
	public AgentTimer(final MiniGameController miniGameController) {
		this.miniGameController = miniGameController;
		this.timeFinish = false;
	}
	
	/**
	 * set the seconds of the GameTimer 
	 * 
	 * @param seconds
	 */
	public void setTime(final int seconds) {
		this.timer = new GameTimerImpl(seconds, this.miniGameController);
	}
	
	/**
	 * stop the flow of the GameTimer
	 */
	public synchronized void stopTimer() {
		super.interrupt();
		this.timeFinish = true;
	}
	
	//questo metodo è da chiamare con "Thred".start()
	@Override
	public void run() {
		while (!this.timeFinish) {
			try {
				this.timer.decrement();
				super.sleep(1000);
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
		
	}
	
	
	

}

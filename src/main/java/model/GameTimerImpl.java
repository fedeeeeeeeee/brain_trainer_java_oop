package model;

import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Consumer;

public class GameTimerImpl implements GameTimer {
	
	private int counter;
	private Consumer<Integer> timerConsumer;
	private Timer timer = new Timer();
	private boolean finish;
			
	public GameTimerImpl(int seconds, Consumer<Integer> timerConsumer) {
		this.counter=seconds;
		this.timerConsumer = timerConsumer;
		this.finish = false;
	}

	@Override
	public void start() {
		this.timer.schedule(new TimerTask() {

			@Override
			public void run() {
				counter--;
				if (counter>=0) {
					if (timerConsumer!=null ) {
						timerConsumer.accept(counter);
					}
				} else {
					finish = true;
				}
			}
			
		}, 0, 1000);
	}

	@Override
	public boolean isTimeFinished() {
		return this.finish;
	}

}

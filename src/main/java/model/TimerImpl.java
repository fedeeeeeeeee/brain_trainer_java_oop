package model;

import java.util.Timer;
import java.util.TimerTask;

public class TimerImpl implements GameTimer {
	
	private int counter;
	private Timer timer = new Timer();
	private TimerTask task = new TimerTask() {

		@Override
		public void run() {
			System.out.println(counter);
		}
				
	};
			
	public TimerImpl(int seconds) {
		this.counter=seconds;
	}

	@Override
	public void start() {
		while (this.counter>0) {
			this.timer.schedule(task, 1000); // 1 seconds
			this.counter--;
		}
	}

	@Override
	public boolean isTimeFinished() {
		return this.counter==0;
	}

}


//public class TimerImpl implements Timer {
//	
//	private int counter;
//	private boolean finish;
//	
//	public TimerImpl(int seconds) {
//		this.counter=seconds;
//		this.finish=false;
//	}
//
//	@Override
//	public void start() {
//		while (!this.finish) {
//			this.counter--;
//		}
//	}
//
//	@Override
//	public boolean isTimeFinished() {
//		return this.finish;
//	}
//
//}

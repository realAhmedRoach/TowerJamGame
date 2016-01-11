package dev.thetechnokid.gather.util;

import java.util.Timer;
import java.util.TimerTask;

public class Countdown {

	private int timeLeft;
	private TimerTask task = new TimerTask() {
		@Override
		public void run() {
			timeLeft--;
			System.out.println(timeLeft);
		}
	};

	public Countdown(int time) {
		timeLeft = time;
	}

	public void start() {
		Timer t = new Timer();
		t.schedule(task, 0, 1000);
	}

	public boolean isDone() {
		if(timeLeft == 0) {
			task.cancel();
		}
		return timeLeft == 0;
	}

	public int timeLeft() {
		return timeLeft;
	}

}

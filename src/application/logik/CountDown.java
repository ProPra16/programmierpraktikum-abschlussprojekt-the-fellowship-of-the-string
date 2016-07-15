// Copyright (c) <2016> <Marcel Beeck, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package application.logik;
//inspiriert von http://www.java-forum.org/thema/countdown-timer-fuer-spiel.96377/

import java.util.Timer;
import java.util.TimerTask;

import FileHandling.Exercise;


public class CountDown {
	private long count;

	public CountDown(Exercise e) {
		count = e.babyLimit();
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {

			public void run() {
				if (count > 0)
					count--;

				if (count == 0)
					System.out.println("Abgelaufen");//TODO
					//Logik.nextStep();//das laeuft NICHT wir brauchen hier das log Objekt
			}
		};
		timer.schedule(task, 0, 1000);
	}
}

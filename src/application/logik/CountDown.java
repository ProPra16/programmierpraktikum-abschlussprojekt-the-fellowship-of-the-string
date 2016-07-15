// Copyright (c) <2016> <Marcel Beeck, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package application.logik;
//inspiriert von http://www.java-forum.org/thema/countdown-timer-fuer-spiel.96377/

import java.util.Timer;
import java.util.TimerTask;

import FileHandling.Exercise;
import javafx.scene.control.TextArea;


public class CountDown extends Thread {
	private String oldText;
	private long count;

	private Timer timer;
	private TextArea area;
	
	public CountDown(Exercise e,TextArea area,boolean isTest) {
		if(isTest)this.oldText=e.getTest();
		else{
			this.oldText=e.getCode();
		}
		
		this.count = e.babyLimit();
		this.area=area;
		
		}
	@Override	
	public void run(){
		try {
			Thread.sleep(count*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.area.setText(this.oldText);
		this.run();
	}
}



// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package application.logik;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;

import FileHandling.Exercise;
import FileHandling.Loader;
import GUI.Controller;

public class Logik{
	
	boolean lauft = true;
	int step; //0 = test schreiben, 1 = code schreiben, 2 = refactor;
	final static int SEC = 1000000000;
	long tr1;
	long tr2 ;
	long trT ;
	long trC;
	long trR;
	Exercise e;
	
	public Logik(Exercise e){
		this.step = 0;
		this.tr1 = 0;
		this.tr2 = 0;
		this.trT = 0;
		this.trC = 0;
		this.trR = 0;
		this.e=e;
	}
	
	
	public void saveLatestCode(String content){ //Tests und Programmcode in Dateien speichern
		e.setCode(content);
	}
	public void saveLatestTest(String content){
		e.setTest(content);
	}
	public void delete(){
		
	}
	public void loadKatalog() { //Den katalog laden und tddt entsprechend einrichten
		Loader.loadExcercise(e);
		
	}
	public boolean nextStep(String code) {
		boolean switchArea=false;
		Exercise tmp = new Exercise();
		tmp = e;
		
		if(e.getBaby()==true) new CountDown(e);
		switch(step){
			case 0: {
				tmp.setTest(code);
				if(tmp.oneFailing()){ //wenn tests kompilieren weiter
					switchArea=true;
					
					if(tmp.getTimer()==true){
					trT += trackStop();
					trackStart();
					}
					e = tmp;
					step = 1;
				}
				else if(tmp.getBaby() == true){
					delete();//TODO
				}
				break;
			}
			case 1:{
				tmp.setCode(code);
				if(tmp.codeCompiles() && tmp.testsRunning()){//wenn compiliert und alle tests laufen weiter
					
					if(tmp.getTimer()==true){
					trC += trackStop();
					trackStart();
					}
					e = tmp;
					step = 2;
				}
				else if(tmp.getBaby() == true){
					delete();//TODO
				}
				break;
			}
			case 2:{
				tmp.setCode(code);
				if(tmp.codeCompiles() && tmp.testsRunning()){//wenn immernoch alles laeuft weiter
					switchArea=true;
					
					if(tmp.getTimer()== true){
					trR += trackStop();
					trackStart();
					}
					if(tmp.getBaby()==true) 
						delete();//TODO
					e = tmp;
					step = 0;
				}
				break;
			}
		}
		return switchArea;
	}

	//fuer tracking
	// TODO trackStart() muss am anfang mit aufgerufen werden!!
	private void trackStart(){
		tr1 = System.nanoTime()/SEC;
	}
	
	private long trackStop(){
		tr2 = System.nanoTime()/SEC;
		return tr2 - tr1;
	}
	
	public void stats(){
		//http://www.math.hu-berlin.de/~ccafm/lehre_BZQ_Numerik/allg/JAVA_Pakete/JFreeChart/Codes/PieChart_code.html
		//JFreeChart Library (GNU License)
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("Red", 100/trT);
		pieDataset.setValue("Refactor", 100/trR);
		pieDataset.setValue("Green",100/ trC);
		
		JFreeChart chart = ChartFactory.createPieChart
		("Time",pieDataset,true,false,false);
		ChartFrame frame = new ChartFrame("Chart", chart);
		frame.pack();
		RefineryUtilities.centerFrameOnScreen(frame);
		frame.setVisible(true);
	}
}

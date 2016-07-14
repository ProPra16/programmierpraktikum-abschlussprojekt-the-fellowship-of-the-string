// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package application.logik;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RefineryUtilities;

import FileHandling.Exercise;
import GUI.Controller;

public class Logik implements LogikZuGui{
	
	boolean lauft = true;
	int step = 0; //0 = test schreiben, 1 = code schreiben, 2 = refactor;
	private final static int SEC = 1000000000;
	static long tr1 = 0;
	static long tr2 = 0;
	long trT = 0;
	long trC = 0;
	long trR = 0;
	Exercise e = new Exercise();
	
	@Override
	public void save() { //Tests und Programmcode in Dateien speichern

	}

	@Override
	public void loadKatalog() { //Den katalog laden und tddt entsprechend einrichten
		
		
	}

	@Override
	public void nextStep() {
		switch(step){
			case 0: {
				if(code.codeCompiles() && test.oneTestFailing()){ //wenn tests kompilieren weiter
					Controller.SwitchArea();//Die GUI methode zum textfeld wechseln wird aufgerufen
					trT += trackStop();
					trackStart();
					step = 1;
				}
				else if(babysteps == true){
					delete();
				}
				break;
			}
			case 1:{
				if(code.codeCompiles() && test.allTestsPassing()){//wenn compiliert und alle tests laufen weiter
					trC += trackStop();
					trackStart();
					step = 2;
				}
				else if(babysteps == true){
					delete();
				}
				break;
			}
			case 2:{
				if(code.codeCompiles() && test.allTestsPassing()){//wenn immernoch alles laeuft weiter
					Controller.SwitchArea();
					trR += trackStop();
					trackStart();
					step = 0;
				}
				break;
			}
		}
	}
	
	//fuer babysteps
	private void countdown(long sekunden){ //wenn aktiviert, wird die übergebene zeit bis null runtergezählt
		lauft = true;
		long deltaT = System.nanoTime();
		while(deltaT != sekunden){
			deltaT += System.nanoTime()/SEC;
		}
		lauft = false;
		nextStep();
	}
	
	//fuer tracking
	// TODO trackStart() muss am anfang mit aufgerufen werden!!
	private void trackStart(){
		tr1 = System.nanoTime()/SEC;
	}
	
	private static long trackStop(){
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

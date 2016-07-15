// Copyright (c) <2016> <Marcel Beeck, Patrick Pirig, Phillippe Weise, Sabine Timmer>
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
		trackStart();
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
		tmp.clone(e);
		
		//if(e.getBaby()==true) new CountDown(e);
		switch(step){
			case 0: {
				
				tmp.setTest(code);
				System.out.println(tmp.oneFailing());
				if(tmp.oneFailing()){ //wenn tests kompilieren weiter
					switchArea=true;
					
					if(tmp.getTimer()==true){
					trT += trackStop();
				//	System.out.println(trT/1000);
					trackStart();
					}
					e.clone(tmp);
					step = 1;
				}
				else if(tmp.getBaby() == true){
					delete();//TODO
				}
				break;
			}
			case 1:{
				System.out.println("case1");
				tmp.setCode(code);
				System.out.println(tmp.testsRunning());
				if(tmp.testsRunning()){//wenn compiliert und alle tests laufen weiter
					switchArea=true;
					if(tmp.getTimer()==true){
					trC += trackStop();
					trackStart();
					}
					e.clone(tmp);
					step = 2;
				}
					break;
			}
				
			
			case 2:{
				System.out.println("case2");
				tmp.setCode(code);
				if(tmp.testsRunning()){//wenn immernoch alles laeuft weiter
					switchArea=true;
					
					if(tmp.getTimer()== true){
					trR += trackStop();
					trackStart();
					}
					e.clone(tmp);
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
		tr1 = System.currentTimeMillis();
	}
	
	private long trackStop(){
		tr2 = System.currentTimeMillis()-tr1;
		return tr2;
	}
	
	
	public void stats(){
		//http://www.math.hu-berlin.de/~ccafm/lehre_BZQ_Numerik/allg/JAVA_Pakete/JFreeChart/Codes/PieChart_code.html
		//JFreeChart Library (GNU License deshalb benutzen wir die MIT-Lizenz)
		long[] arr=new long[3];
		arr[0]=trT/1000;arr[1]=trR/1000;arr[2]=trC/1000;
		String[] timeText=new String[3];
		for(int i=0;i<timeText.length;i++){
			long sek=arr[i]%60;
			long min=arr[i]/60;
			if(sek<10){
				timeText[i]=min+" : 0"+sek;
			}
			else {
				timeText[i]=min+" : "+sek;
			}
		}
		long ges=(trT+trR+trC)/100;
		DefaultPieDataset pieDataset = new DefaultPieDataset();
		pieDataset.setValue("Red: "+timeText[0]+"min", ges*trT);
		pieDataset.setValue("Refactor: "+timeText[1]+"min", ges*trR);
		pieDataset.setValue("Green: "+timeText[2]+"min",ges*trC);
		
		JFreeChart chart = ChartFactory.createPieChart
		("Time",pieDataset,true,false,false);
		ChartFrame frame = new ChartFrame("Chart", chart);
		frame.pack();
		RefineryUtilities.centerFrameOnScreen(frame);
		frame.setVisible(true);
	}
}

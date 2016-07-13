/*******************************************************************************
 * Copyright (c) 2016 The Fellowship of the String and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Marcel Beek - initial API and implementation
 *     Patrick Pirig - initial API and implementation
 *     Phillippe Weise - initial API and implementation
 *     Sabine Timmer - initial API and implementation
 *******************************************************************************/
package application.logik;

import FileHandling.Exercise;
import GUI.Controller;

public class Logik implements LogikZuGui{
	
	boolean lauft = true;
	int step = 0; //0 = test schreiben, 1 = code schreiben, 2 = refactor;
	private final int SEC = 1000000000;
	long tr1 = 0, tr2 = 0, trT = 0, trC = 0, trR = 0;
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
	
	private long trackStop(){
		tr2 = System.nanoTime()/SEC;
		return tr2 - tr1;
	}
	
}

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

public class Logik implements LogikZuGui{
	
	Exercise e = new Exercise();
	
	@Override
	public void save() { //Tests und Programmcode in Dateien speichern
		
		
	}

	@Override
	public void loadKatalog() { //Den katalog laden und tddt entsprechend einrichten
		
		
	}

	@Override
	public void nextStep() { //wenn der code kompiliert, wird zum nächsten schritt gewechselt
		if(e.codeCompiles()){
			
		}
		
	}
	

	private void countdown(long minuten){ //wenn aktiviert, wird 
		long t1 = 0;
		long t2 = System.nanoTime();
		long deltaT = t2 - t1;
		while(minuten-deltaT != 0){
			
		}
	}
	
}

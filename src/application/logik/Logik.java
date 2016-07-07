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
	
<<<<<<< HEAD
	private void countdown(long minuten){ //wenn aktiviert, wird 
		long t1 = 0;
		long t2 = System.nanoTime();
		long deltaT = t2 - t1;
		while(minuten-deltaT != 0){
			
=======
	private boolean isCompileable(){
		if(true){
			return true;
>>>>>>> refs/remotes/origin/master
		}
	}
	
	
	
}

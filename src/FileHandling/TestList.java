package FileHandling;

import java.util.ArrayList;

public class TestList extends ArrayList<Test>{

	private static final long serialVersionUID = 1L;
	private boolean running;

	
	public TestList(){
		super();
	}
	
	public boolean allPassing(){
	
		Test[] codeArray =  (Test[]) this.toArray();
		
		for(int i = 0; i< codeArray.length; i++){
			running = codeArray[i].oneTestFailing();
			
				if(running == false) return false;
		}
		return true;
	}
}

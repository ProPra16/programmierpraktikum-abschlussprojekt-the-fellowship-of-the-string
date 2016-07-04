package FileHandling;

public class Exercise {
	
	private String description;
	private CodeList klassen;
	private TestList tests;
	private boolean baby,timer;
	
	
	public Exercise(){
		
	}
	
	public boolean codeCompiles(){
		
		return this.klassen.compilable();

	}

}

package FileHandling;

public class Exercise {
	
	private String description;
	private CodeList klassen;
	private TestList tests;
	private boolean baby,timer;
	
	
	public Exercise(String description,CodeList klassen,TestList tests,boolean baby,boolean timer){
		this.description=description;
		this.klassen=klassen;
		this.tests=tests;
		this.baby=baby;
		this.timer=timer;
	}
	
	public Exercise(){
		
		
	}
	public boolean codeCompiles(){
		
		return this.klassen.compilable();

	}

}

package FileHandling;

public class Exercise {
	
	private String description;
	private CodeList klassen;
	private TestList tests;
	private boolean baby,timer;
	
	private boolean compilable;
	
	public Exercise(){
		
	}
	
	public boolean compilable(Code object){
		
		compilable = object.testingCompilationUnit();
		
		return compilable;
	}

	}

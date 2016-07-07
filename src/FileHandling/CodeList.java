package FileHandling;

import java.util.ArrayList;

public class CodeList extends ArrayList<Code>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean compilable;

	
	public CodeList(){
		super();
	}
	
	public boolean compilable(){
	
		Code[] codeArray =  (Code[]) this.toArray();
		
		for(int i = 0; i< codeArray.length; i++){
			compilable = codeArray[i].testingCompilationUnit();
			
			if(compilable == false) return false;
		}
		return true;
	}
}

package FileHandling;

import java.util.ArrayList;

public class TestList extends ArrayList<Test>{

	private static final long serialVersionUID = 1L;
	private boolean compilable;

	
	public TestList(){
		super();
	}
	
	public boolean compilable(){
	
		Test[] codeArray =  (Test[]) this.toArray();
		
		for(int i = 0; i< codeArray.length; i++){
			//muss noch
			
			if(compilable == false) return false;
		}
		return true;
	}
}

package FileHandling;

import java.util.ArrayList;

public class CodeList extends ArrayList<Code>{
	
	private boolean compilable;
	private ArrayList<Code> codeList;
	
	public CodeList(Code code){
		this.codeList = new ArrayList<>();
		codeList.add(code);
		
	}
	
	public boolean compilable(){
	
		Code[] codeArray =  (Code[]) this.codeList.toArray();
		
		for(int i = 0; i< codeArray.length; i++){
			compilable = codeArray[i].testingCompilationUnit();
			
			if(compilable == false) return false;
		}
		return true;
		
	}
}

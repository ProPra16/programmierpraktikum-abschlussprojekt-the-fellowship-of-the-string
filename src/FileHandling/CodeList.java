// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package FileHandling;

import java.io.IOException;
import java.util.ArrayList;

public class CodeList extends ArrayList<Code> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean compilable;

	public CodeList() {
		super();
	}

	public boolean compilable() {

		Object[] codeArray = this.toArray();

		for (int i = 0; i < codeArray.length; i++) {
			compilable = ((Code) codeArray[i]).testingCompilationUnit();

			if (compilable == false)
				return false;
		}
		return true;
	}
	public String getCodeText(){
		return this.get(0).toString();
	}
	public void saveCode() throws IOException{
		this.get(0).save();
	}
}

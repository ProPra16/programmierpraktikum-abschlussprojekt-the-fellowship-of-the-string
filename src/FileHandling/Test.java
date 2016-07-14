// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package FileHandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import vk.core.api.CompilationUnit;
import vk.core.api.CompilerFactory;
import vk.core.api.JavaStringCompiler;
import vk.core.api.TestResult;

public class Test {
	private String testName;
	private String testCode;
	private CompilationUnit compilationUnitTest;

	public Test( String testName,String testCode) {
		this.testCode = testCode;
		this.testName=testName;
		this.compilationUnitTest = new CompilationUnit(testName, testCode, true);
	}
	
	public String getTestText(){
		return this.testCode;
	}

	public boolean oneTestFailing() {
		JavaStringCompiler compiler = CompilerFactory.getCompiler(compilationUnitTest);
		compiler.compileAndRunTests();
		TestResult result = compiler.getTestResult();
		int fails = result.getNumberOfFailedTests();

		if (fails == 1)
			return true;
		return false; // mehr als ein test schlaegt fehl sollte nicht sein im
						// tddt kreislauf
	}

	public boolean allTestsPassing() {
		JavaStringCompiler compiler = CompilerFactory.getCompiler(compilationUnitTest);
		compiler.compileAndRunTests();
		TestResult result = compiler.getTestResult();
		int fails = result.getNumberOfFailedTests();

		if (fails == 0)
			return true;
		return false;

	}
	public void save() throws IOException{
		File file=new File(this.testName+".java");
		FileWriter writer=new FileWriter(file,true);
		BufferedWriter out=new BufferedWriter(writer);
		out.write(this.testCode);
		out.close();
		writer.close();	
	}
}

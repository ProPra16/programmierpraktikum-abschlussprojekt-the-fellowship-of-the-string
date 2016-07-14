// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package FileHandling;

import vk.core.api.CompilationUnit;
import vk.core.api.CompilerFactory;
import vk.core.api.JavaStringCompiler;
import vk.core.api.TestResult;

public class Test {
	private String testCode;
	private CompilationUnit compilationUnitTest;

	public Test( String testName,String testCode) {
		this.testCode = testCode;
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
}

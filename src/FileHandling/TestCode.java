// Copyright (c) <2016> <Marcel Beeck, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package FileHandling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import GUI.Warner;
import vk.core.api.CompilationUnit;
import vk.core.api.CompileError;
import vk.core.api.CompilerFactory;
import vk.core.api.CompilerResult;
import vk.core.api.JavaStringCompiler;
import vk.core.api.TestHelpers;
import vk.core.api.TestResult;

public class TestCode {
	private String testName;
	private String testCode;
	private CompilationUnit compilationUnitTest;

	public TestCode( String testName,String testCode) {
		this.testCode = testCode;
		this.testName=testName;
	}
	
	public String getTestText(){
		return this.testCode;
	}

	public boolean oneTestFailing(CompilationUnit compilationUnitCode) {
		this.compilationUnitTest = new CompilationUnit(testName, testCode, true);
		JavaStringCompiler compiler = CompilerFactory.getCompiler(compilationUnitCode,compilationUnitTest);
		compiler.compileAndRunTests();
		CompilerResult compilerResult = compiler.getCompilerResult();
		if (compilerResult.hasCompileErrors() == true) {
			
			Warner.display("UPS, etwas Compeliert nicht :(");

			return false;}		//muss vorher kompilieren
		TestResult result = compiler.getTestResult();
		int fails = result.getNumberOfFailedTests();

		if (fails == 1)return true;
		return false; // mehr als ein test schlaegt fehl sollte nicht sein im
						// tddt kreislauf
	}

	public boolean allTestsPassing(CompilationUnit compilationUnitCode) {
		this.compilationUnitTest = new CompilationUnit(testName, testCode, true);
		JavaStringCompiler compiler = CompilerFactory.getCompiler(compilationUnitCode,compilationUnitTest);
		compiler.compileAndRunTests();
		CompilerResult compilerResult = compiler.getCompilerResult();
		if (compilerResult.hasCompileErrors() == true) {
			Warner.display("UPS, etwas Compeliert nicht :(");

			return false;}
		
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

	public void setTestText(String newContent) {
		this.testCode = newContent;
	}

	public String getName() {
		
		return this.testName;
	}

	public CompilationUnit getTestUnit() {
		return this.compilationUnitTest = new CompilationUnit(testName, testCode, true);		}
}

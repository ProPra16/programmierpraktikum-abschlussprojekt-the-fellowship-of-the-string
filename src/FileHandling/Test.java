package FileHandling;

import vk.core.api.CompilationUnit;
import vk.core.api.CompilerFactory;
import vk.core.api.CompilerResult;
import vk.core.api.JavaStringCompiler;
import vk.core.api.TestResult;
import vk.core.internal.InternalResult;

public class Test {
	private String testCode;
	private CompilationUnit compilationUnitTest;
	
	public Test(String testCode, String testName){
		this.testCode=testCode;
		this.compilationUnitTest= new CompilationUnit(testName, testCode, true);
	}
	
	public boolean oneTestFailing(){
		JavaStringCompiler compiler = CompilerFactory.getCompiler(compilationUnitTest);
		compiler.compileAndRunTests();
		TestResult result = compiler.getTestResult();
		int fails = result.getNumberOfFailedTests();
		
		if(fails == 1) return true;		
		return false;		//mehr als ein test schlägt fehl sollte nicht sein im tddt kreislauf
	}
	
	public boolean allTestsPassing(){
		JavaStringCompiler compiler = CompilerFactory.getCompiler(compilationUnitTest);
		compiler.compileAndRunTests();
		TestResult result = compiler.getTestResult();
		int fails = result.getNumberOfFailedTests();
		
		if(fails == 0) return true;		
		return false;
		
	}
}

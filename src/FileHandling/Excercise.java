package FileHandling;

import static org.junit.Assert.*;
import vk.core.api;
import vk.core.internal;

public class Excercise {
	
	private boolean status;
	private CompilationUnit input;
	
	public Excercise(){
		
	}
	
	public boolean compilable(String className, String classContent){
		
		input = new CompilationUnit(className, classContent, true );
		
		status = testingInput_NoCompileErrors();
//		status = testingInput_CompileErrors();
		
		
		return status;
	}
	
	public boolean testingInput_NoCompileErrors(){
		JavaStingCompiler compiler = CompilerFactory.getCompiler(input);
		input.compileAndRunTests();
		CompilerResult result = compiler.getCompilerResult();
		assertFalse(TestHelpers.getErrorMessages(compiler, result), result.hasCompileErrors());
		
		return status = true;
	}
	
/*	public boolean testingInput_CompileErrors() {
		JavaStringCompiler compiler = CompilerFactory.getCompiler(input);
		compiler.compileAndRunTests();
		CompilerResult result = compiler.getCompilerResult();
		assertTrue(result.hasCompileErrors());
		
		return status = false;
	}*/

}

package FileHandling;

import static org.junit.Assert.*;
import vk.core.api;
import vk.core.internal;

public class Exercise {
	
	private boolean status;
	private CompilationUnit input;
	
	public Exercise(){
		
	}
	
	public boolean compilable(String className, String classContent){
		
		input = new CompilationUnit(className, classContent, true );
		
		status = testingInput();
		
		return status;
	}
	
	public boolean testingInput(){
		JavaStingCompiler compiler = CompilerFactory.getCompiler(input);
		input.compileAndRunTests();
		CompilerResult result = compiler.getCompilerResult();
		
		if(result.hasCompileErrors == true) status = true;		//keine compilerfehler
		
		else{
			TestHelpers.getErrorMessages(compiler, result);
			status = false;
		}
		
		return status;
	}
	}

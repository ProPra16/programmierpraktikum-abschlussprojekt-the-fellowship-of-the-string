package FileHandling;

import vk.core.api.CompilationUnit;
import vk.core.api.CompilerFactory;
import vk.core.api.CompilerResult;
import vk.core.api.JavaStringCompiler;
import vk.core.api.TestHelpers;

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
		JavaStringCompiler compiler = CompilerFactory.getCompiler(input);
		compiler.compileAndRunTests();
		CompilerResult result = compiler.getCompilerResult();
		
		if(result.hasCompileErrors() == true) status = true;		//keine compilerfehler
		
		else{
			TestHelpers.getErrorMessages(compiler, result);
			status = false;
		}
		
		return status;
	}
	}

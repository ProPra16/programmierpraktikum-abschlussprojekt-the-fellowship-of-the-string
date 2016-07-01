package FileHandling;

import vk.core.api.CompilationUnit;
import vk.core.api.CompilerFactory;
import vk.core.api.CompilerResult;
import vk.core.api.JavaStringCompiler;
import vk.core.api.TestHelpers;

public class Exercise {
	
	private String description;
	private CodeList klassen;
	private TestList tests;
	private boolean baby,timer;
	
	private boolean status;
	private CompilationUnit input;
	
	public Exercise(){
		
	}
	
	public boolean compilable(String className, String classContent){
	// muss ein bisschen anders	
		input = new CompilationUnit(className, classContent, true );
		
		status = testingInput();
		
		return status;
	}
	
	public boolean testingInput(){//ebenfalls
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

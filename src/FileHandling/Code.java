package FileHandling;

import vk.core.api.CompilationUnit;
import vk.core.api.CompilerFactory;
import vk.core.api.CompilerResult;
import vk.core.api.JavaStringCompiler;
import vk.core.api.TestHelpers;

public class Code {

	private String code;
	private String className;
	private CompilationUnit input;
	private boolean compilable;
	
	
	public Code(String className,String code){
		this.code=code;
		this.className=className;
		this.input = new CompilationUnit(className, code, true );
		this.compilable = testingInput();

	}
	
	public boolean testingInput(){
		JavaStringCompiler compiler = CompilerFactory.getCompiler(input);
		compiler.compileAndRunTests();
		CompilerResult result = compiler.getCompilerResult();
		
		if(result.hasCompileErrors() == true) compilable = true;	
		
		else{
			TestHelpers.getErrorMessages(compiler, result);
			compilable = false;
		}
		
		return compilable;
	}
}

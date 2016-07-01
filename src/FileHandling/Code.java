package FileHandling;

import vk.core.api.CompilationUnit;
import vk.core.api.CompilerFactory;
import vk.core.api.CompilerResult;
import vk.core.api.JavaStringCompiler;
import vk.core.api.TestHelpers;

public class Code {

	private String code;
	private String className;
	private CompilationUnit compilationUnit;
	private boolean compilable;
	
	
	public Code(String className,String code){
		this.code=code;
		this.className=className;
		this.compilationUnit = new CompilationUnit(className, code, true );
		this.compilable = testingCompilationUnit();

	}
	
	public boolean testingCompilationUnit(){
		JavaStringCompiler compiler = CompilerFactory.getCompiler(compilationUnit);
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

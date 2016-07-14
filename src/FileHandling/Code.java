// Copyright (c) <2016> <Marcel Beek, Patrick Pirig, Phillippe Weise, Sabine Timmer>
package FileHandling;

import vk.core.api.CompilationUnit;
import vk.core.api.CompilerFactory;
import vk.core.api.CompilerResult;
import vk.core.api.JavaStringCompiler;
import vk.core.api.TestHelpers;

public class Code {

	private String code;
	private String className;
	private CompilationUnit compilationUnitCode;
	private boolean compilable;

	public Code(String className, String code) {
		this.code = code;
		this.className = className;
		this.compilationUnitCode = new CompilationUnit(className, code, false);
		//this.compilable = testingCompilationUnit();

	}

	public boolean testingCompilationUnit() {
		JavaStringCompiler compiler = CompilerFactory.getCompiler(compilationUnitCode);
		compiler.compileAndRunTests();
		CompilerResult result = compiler.getCompilerResult();

		if (result.hasCompileErrors() == true) {
			System.out.println(TestHelpers.getErrorMessages(compiler, result));
			compilable = false;
		}

		else if (result.hasCompileErrors() == false)
			compilable = true;

		return compilable;
	}

}

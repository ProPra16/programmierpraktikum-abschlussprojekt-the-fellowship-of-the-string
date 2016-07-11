/*******************************************************************************
 * Copyright (c) 2016 The Fellowship of the String and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Marcel Beek - initial API and implementation
 *     Patrick Pirig - initial API and implementation
 *     Phillippe Weise - initial API and implementation
 *     Sabine Timmer - initial API and implementation
 *******************************************************************************/
package FileHandling;

import vk.core.api.CompilationUnit;
import vk.core.api.CompileError;
import vk.core.api.CompilerFactory;

import vk.core.api.CompilerResult;

import vk.core.api.JavaStringCompiler;

import vk.core.api.TestHelpers;
import vk.core.api.TestResult;
import vk.core.internal.InternalResult;

public class Code {

	private String code;
	private String className;
	private CompilationUnit compilationUnitCode;
	private boolean compilable;

	public Code(String className, String code) {
		this.code = code;
		this.className = className;
		this.compilationUnitCode = new CompilationUnit(className, code, false);
		this.compilable = testingCompilationUnit();

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

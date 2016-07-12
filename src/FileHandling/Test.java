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
import vk.core.api.CompilerFactory;
import vk.core.api.CompilerResult;
import vk.core.api.JavaStringCompiler;
import vk.core.api.TestResult;
import vk.core.internal.InternalResult;

public class Test {
	private String testCode;
	private CompilationUnit compilationUnitTest;

	public Test(String testCode, String testName) {
		this.testCode = testCode;
		this.compilationUnitTest = new CompilationUnit(testName, testCode, true);
	}

	public boolean oneTestFailing() {
		JavaStringCompiler compiler = CompilerFactory.getCompiler(compilationUnitTest);
		compiler.compileAndRunTests();
		TestResult result = compiler.getTestResult();
		int fails = result.getNumberOfFailedTests();

		if (fails == 1)
			return true;
		return false; // mehr als ein test schlägt fehl sollte nicht sein im
						// tddt kreislauf
	}

	public boolean allTestsPassing() {
		JavaStringCompiler compiler = CompilerFactory.getCompiler(compilationUnitTest);
		compiler.compileAndRunTests();
		TestResult result = compiler.getTestResult();
		int fails = result.getNumberOfFailedTests();

		if (fails == 0)
			return true;
		return false;

	}
}

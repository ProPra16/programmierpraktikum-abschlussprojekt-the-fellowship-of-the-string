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

public class Exercise {

	private String description;
	private CodeList klassen;
	private TestList tests;
	private boolean baby, timer;

	public Exercise(String description, CodeList klassen, TestList tests, boolean baby, boolean timer) {
		this.description = description;
		this.klassen = klassen;
		this.tests = tests;
		this.baby = baby;
		this.timer = timer;
	}

	public Exercise() {

	}

	public boolean codeCompiles() {

		return this.klassen.compilable();

	}

	public boolean testsRunning() {

		return this.tests.allPassing();
	}

}

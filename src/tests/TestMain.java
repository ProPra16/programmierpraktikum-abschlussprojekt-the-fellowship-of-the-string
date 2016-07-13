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
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import FileHandling.Code;
import FileHandling.CodeList;

public class TestMain {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Test
	public void testCodeCompilableTrue() {
		Code c = new Code("Foo",
				"public class Foo{ public static void main(String[] args){ System.out.println(15); }}");// c
																										// =
																										// richtiger
																										// Hello
																										// World
																										// testcode;
		assertEquals(true, c.testingCompilationUnit()); // fehler wegen
														// anf�hrungzeichen
														// innerhalb des prints,
														// deshalb stattdessen
														// zahlen
	}

	@Test
	public void testCodeCompilableFalse() {
		Code c = new Code("Foo", "dieser code laeuft nicht");
		assertEquals(false, c.testingCompilationUnit());
	}

	@Test
	public void testCodeListCompilableTrue() {
		CodeList l = new CodeList();
		Code c1 = new Code("Foo", "public class Foo{public static void main(String[] args){System.out.println(16);}}");
		Code c2 = new Code("Bar", "public class Bar{public static void main(String[] args){System.out.println(17);}}");
		l.add(c1);
		l.add(c2);
		assertEquals(true, l.compilable());
	}

	@Test
	public void testCodeListCompilableFalse() {
		CodeList l = new CodeList();
		Code c1 = new Code("Foo", "public class Foo{public static void main(String[] args){System.out.println(18);}}");// richtiger
																														// code
																														// todo
		Code c2 = new Code("Bar", "dieser code laeuft nicht");// falscher code
		l.add(c1);
		l.add(c2);
		assertEquals(false, l.compilable());
	}

}
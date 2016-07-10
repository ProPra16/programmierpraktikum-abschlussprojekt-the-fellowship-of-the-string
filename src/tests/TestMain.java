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
	public void testCodeCompilableTrue(){
		Code c = new Code("Foo", "public class Foo{public static void main(String[] args){System.out.println("+"Hello World"+");}}");//c = richtiger Hello World testcode;
		assertEquals(true, c.testingCompilationUnit());
	}
	
	@Test
	public void testCodeCompilableFalse(){
		Code c = new Code("Foo", "dieser code laeuft nicht");
		assertEquals(false, c.testingCompilationUnit());
	}
	
	@Test
	public void testCodeListCompilableTrue(){
		CodeList l = new CodeList();
		Code c1 = new Code("Foo", "public class Foo{public static void main(String[] args){System.out.println(" + "Hello World" + ");}}");
		Code c2 = new Code("Bar", "public class Foo{public static void main(String[] args){System.out.println(Hello World);}}");
		l.add(c1);
		l.add(c2);
		assertEquals(true, l.compilable());
	}
	
	@Test
	public void testCodeListCompilableFalse(){
		CodeList l = new CodeList();
		Code c1 = new Code("Foo", "public class Foo{public static void main(String[] args){System.out.println("+"Hello World"+");}}");//richtiger code todo
		Code c2 = new Code("Bar", "dieser code laeuft nicht");//falscher code
		l.add(c1);
		l.add(c2);
		assertEquals(false, l.compilable());
	}
	
}

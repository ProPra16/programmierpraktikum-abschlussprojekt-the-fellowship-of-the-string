package FileHandling;

import java.io.IOException;

public class SaveTest {
	
	public static void main(String[] args){
		
		String desc ="Guten tag";
		CodeList list =new CodeList();
		Code code =new Code("HelloWorld","public class hello {public static void main(String[] args){System.out.println(a);}}");
		list.add(code);
		Test test =new Test("HelloTest","import static org.junit.Assert.*;import org.junit.Test;public class RomanNumbersTest {@Testpublic void testSomething() {}}");
		Exercise exer =new Exercise(desc,list,test,false,false);
		
		try {
			exer.save();
		} catch (IOException e) {
			System.out.println("AUA");
		}
	}
}

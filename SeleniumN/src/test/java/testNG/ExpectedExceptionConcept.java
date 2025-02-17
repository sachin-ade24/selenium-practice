package testNG;

import org.testng.annotations.Test;

public class ExpectedExceptionConcept {
	
	String name;
	
	@Test(expectedExceptions = {ArithmeticException.class, NullPointerException.class})
	public void loginTest() {
		System.out.println("login Test");
		int i = 9/0;//AE
		ExpectedExceptionConcept obj = null;
		obj.name = "Tom";
	}
	
	@Test(expectedExceptions = Exception.class)
	public void aTest() {
		System.out.println("Test");
		int i = 9/0;//AE
	}
	
	/*if no priority assigned means it has default priority i.e 0*/
	@Test(expectedExceptions =  Exception.class)
	public void bTest() {
		System.out.println("bTest");
		int i = 9/0;//AE
	}
	
	@Test(expectedExceptions = Exception.class)
	public void cTest() {
		System.out.println("cTest");
		int i = 9/0;//AE
	}
	
	@Test(expectedExceptions = Exception.class)
	public void dTest() {
		System.out.println("dTest");
		int i = 9/0;//AE
	}
	
}

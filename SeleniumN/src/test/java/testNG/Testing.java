package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testing {
	
	@Test
	public void testMethod1() {
		System.out.println("test method1");
		int a = 10;
		int b = 20;
		int sum = a+b;
		//If your test case fails then only your message will be displayed 
		//on the console.
		//Assert.assertEquals(sum, 40, "Both are not equal..");
		Assert.assertEquals(sum, 10);
	}
	
	@Test
	public void testMethod2() {
		System.out.println("test method1");
		int a = 10;
		int b = 20;
		int division = b/a;
		Assert.assertEquals(division, 20);
	}
	
	//writing main method in the TestNG class does not make any sense
	//we do not write main method in the TestNG class because TestNG does
	//not recognize main method as a test.
	
	//I can write the main method with @Test annotation but, TestNG will
	//not execute main method.
	//In order to execute main method in the TestNG class, we need to run
	//the test as 'Java Application'. 
	
	//No run time or compile time exception or error but
	//using TestNG test, we cannot execute main method, need to execute
	//using Java Application.
	//@Test
	//public static void main(String[] args) {
	//	System.out.println("Main method");
	//}

}

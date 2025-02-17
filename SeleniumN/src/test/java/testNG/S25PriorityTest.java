package testNG;

import org.testng.annotations.Test;

public class S25PriorityTest {
	
	@Test(priority = 1)
	public void aTest() {
		System.out.println("Test");
	}
	
	/*if no priority assigned means it has default priority i.e 0*/
	@Test
	public void bTest() {
		System.out.println("bTest");
	}
	
	@Test(priority = -1)
	public void cTest() {
		System.out.println("cTest");
	}
	
	@Test(priority = 2)
	public void dTest() {
		System.out.println("dTest");
	}
	
	@Test(priority = 4)
	public void eTest() {
		System.out.println("eTest");
	}
	
	@Test
	public void Test() {
		System.out.println("Test");
	}
	
	@Test()
	public void b1Test() {
		System.out.println("a1Test");
	}
}

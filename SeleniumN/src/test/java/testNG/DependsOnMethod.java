package testNG;

import org.testng.annotations.Test;

public class DependsOnMethod {
	
	/*now priority will not decided by alphabetically, because
	 *here tests are dependent. The one which does not depend on other
	 *test will get executed first.
	*/
	
	@Test()
	public void loginTest() {
		System.out.println("login Test");
		//int i = 9/0;
	}
	
	/*if independent test fails and if other tests are dependent on that 
	 *independent test, then all dependent tests will get skipped.*/
	
	@Test(dependsOnMethods = "loginTest")
	public void homeTest() {
		System.out.println("home Test");
	}
	
	@Test(dependsOnMethods = "homeTest")
	public void carTest() {
		System.out.println("car Test");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package testNG;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	//Execute the same test for 10 times
	@Test(invocationCount = 10)
	public void createUser() {
		System.out.println("Create user.");
	}
	
}

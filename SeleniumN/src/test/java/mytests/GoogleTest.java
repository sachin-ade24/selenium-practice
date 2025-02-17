package mytests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class GoogleTest extends BaseTest{
	
	@Test
	public void titleTest() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Google");
	}
	
	//we can ignore the test meaning we can skip the test
	//by writing @Ignore or @Test(enabled = false)
	//If you don't want to skip then write @Test(enabled = true)
	@Test(enabled = true)
	public void currentUrlTest() {
		String URL = driver.getCurrentUrl();
		System.out.println(URL);
		Assert.assertTrue(URL.contains("google"));
	}
	
}

package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotations {
	
	/* p --> priority
	 
	 p1 -- connectWithDb -- @BeforeSuite
	 p2 -- createUser -- @BeforeTest
	 p3 -- launchBrowser -- @BeforeClass
	 
	 p4/p7/p10 -- loginTOApp -- @BeforeMethod
	 p5 -- searchTest -- @Test
	 p6/p9/p12 -- logout -- @AfterMethod
	 
	 p4/p7/p10 -- loginTOApp -- @BeforeMethod
	 p8 -- titleTest -- @Test
	 p6/p9/p12 -- logout -- @AfterMethod
	 
	 p4/p7/p10 -- loginTOApp -- @BeforeMethod
	 p11 -- urlTest -- @Test
	 p6/p9/p12 -- logout -- @AfterMethod
	 
	 p13 -- closeBrowser -- @AfterClass
	 p14 -- deleteUser -- @AfterTest
	 p15 -- disconnectDb -- @AfterSuite
	 
	*/
	
	//1
	@BeforeSuite
	public void connectWithDb() {
		System.out.println("p1 -- connectWithDb -- @BeforeSuite");
	}
	
	//2
	@BeforeTest
	public void createUser() {
		System.out.println("p2 -- createUser -- @BeforeTest");
	}
	
	//3
	@BeforeClass
	public void launchBrowser() {
		System.out.println("p3 -- launchBrowser -- @BeforeClass");
	}
	
	//4//7//10
	@BeforeMethod
	public void loginToApp() {
		System.out.println("p4/p7/p10 -- loginTOApp -- @BeforeMethod");
	}
	
	//8
	@Test
	public void titleTest() {
		System.out.println("p8 -- titleTest -- @Test");
	}
	
	//11
	@Test
	public void urlTest() {
		System.out.println("p11 -- urlTest -- @Test");
	}
	
	//5
	@Test
	public void searchTest() {
		System.out.println("p5 -- searchTest -- @Test");
	}
	
	//6//9//12
	@AfterMethod
	public void logout() {
		System.out.println("p6/p9/p12 -- logout -- @AfterMethod");
	}
	
	//13
	@AfterClass
	public void closeBrowser() {
		System.out.println("p13 -- closeBrowser -- @AfterClass");
	}
	
	//14
	@AfterTest
	public void deleteUser() {
		System.out.println("p14 -- deleteUser -- @AfterTest");
	}
	
	//15
	@AfterSuite
	public void disconnectDb() {
		System.out.println("p15 -- disconnectDb -- @AfterSuite");
	}
	
}

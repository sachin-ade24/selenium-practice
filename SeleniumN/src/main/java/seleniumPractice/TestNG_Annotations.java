package seleniumPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Annotations {
	
	@BeforeSuite
	public void m1() {
		
	}
	
	@BeforeTest
	public void m2() {
		
	}
	
	@BeforeMethod
	public void m3() {
		//alphabetic order of @Test methods
		//priority
		//1. ma4
		//2. mb4
		//3. mc4
	}
	
	@Test
	public void mc4() {
		
	}
	
	@Test
	public void mb5() {
		
	}
	
	@Test
	public void ma6() {
		
	}
	
	@AfterMethod
	public void m7() {
		
	}
	
	@AfterClass
	public void m8() {
		
	}
	
	@AfterTest
	public void m9() {
		
	}
	
	@AfterSuite
	public void m10() {
		
	}

}

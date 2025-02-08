package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//1.
		//driver.findElement(By.id("input-email")).sendKeys("sachin123@amail.com");
		//driver.findElement(By.id("input-password")).sendKeys("S@chin123");
		
		//2.
		//WebElement emailEle = driver.findElement(By.id("input-email"));
		//WebElement passwordEle = driver.findElement(By.id("input-password"));
		
		//emailEle.sendKeys("sachin123@amail.com");
		//passwordEle.sendKeys("S@chin123");
		
		//3.
		//By email = By.id("input-email");
		//By password = By.id("input-password");
		
		//WebElement emailEle = driver.findElement(email);
		//WebElement passwordEle = driver.findElement(password);
		
		//emailEle.sendKeys("sachin123@amail.com");
		//passwordEle.sendKeys("S@chin123");
		
		//4. create a reusable method for finding element:
		//By email = By.id("input-email");
		//By password = By.id("input-password");
		
		//getElement(email).sendKeys("sachin123@amail.com");
		//getElement(password).sendKeys("S@chin123");
		
		//5. reduce again: by creating a type method;
		//By email = By.id("input-email");
		//By password = By.id("input-password");
		//type(email, "sachin123@amail.com");
		//type(password, "S@chin123");
		
		//6. Create ElementUtil class:
		By email = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtilS5 obj = new ElementUtilS5(driver);
		obj.type(email, "sachin123@amail.com");
		obj.type(password, "S@chin123");

	}
	
	//public static WebElement getElement(By elementLocator) {
	//	return driver.findElement(elementLocator);
	//}
	
	//public static void type(By elementLocator, String text) {
	//	getElement(elementLocator).sendKeys(text);
	//}

}

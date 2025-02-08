package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsDisplayed {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//boolean flag = driver.findElement(By.id("input-email")).isDisplayed();
		//System.out.println(flag);
		
		By email = By.id("input-email");
		//By email = By.id("input-email11");
		//NoSuchElementException
		if(isElementDisplayed(email)) {
			type(email, "test@mail.com");
		}else {
			System.out.println("Element is not displayed..");
		}
		
	}
	
	public static WebElement getElement(By elementLocator) {
		return driver.findElement(elementLocator);
	}
	
	public static boolean isElementDisplayed(By elementLocator) {
		return getElement(elementLocator).isDisplayed();
	}
	
	public static void type(By elementLocator, String text) {
		getElement(elementLocator).sendKeys(text);
	}

}

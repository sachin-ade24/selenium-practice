package seleniumS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DoesElementExistConceptS8 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver =  new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//List<WebElement> emailIdList = driver.findElements(By.id("input-email"));

		//if(emailIdList.size()==1) {
		//	System.out.println("Email field is displayed on the page.");
		//}else {
		//	System.out.println("Email filed is not displayed on the page.");
		//}
		
		//System.out.println(getElements(By.id("input-email")));
		
		System.out.println(isElementDisplayed(By.id("input-email")));

	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	} 
	
	public static boolean isElementDisplayedAtLeastOnce(By locator) {
		if(getElements(locator).size()==1) {
			System.out.println("Element is displayed on the page.");
			return true;
		}else {
			System.out.println("Element is not displayed on the page.");
			return false;
		}
	}
	
	public static boolean areElementDisplayed(By locator, int elementCount) {
		if(getElements(locator).size()==elementCount) {
			System.out.println("Element is displayed on the page.");
			return true;
		}else {
			System.out.println("Element is not displayed on the page.");
			return false;
		}
	}
	
	public static WebElement getElement(By elementLocator) {
		return driver.findElement(elementLocator);
	}
	
	public static boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		}catch(NoSuchElementException e){
			System.out.println("Element is not displayed.");
			return false;
		}
	}

}

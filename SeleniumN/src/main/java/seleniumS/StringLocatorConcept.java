package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StringLocatorConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String input = "input-";
		String email_id = "email";
		String password_id = "password";
		String login_btn_xpath = "//*[@id=\"content\"]/div/div[2]/div/form/input";
		
		//type(getLocator("id", email_id), "s@b.com");
		//type("id", email_id, "s@b.com");
		type("id", input + email_id, "s@b.com");
		//type(getLocator("id", password_id), "S@123");
		//type("id", password_id, "S@123");
		type("id", input + password_id, "S@123");
		//clickOnTheElement(getLocator("xpath", login_btn_xpath));
		clickOnTheElement("xpath", login_btn_xpath);
		
		System.out.println("Task completed.");
		
		driver.quit();
	}
	
	public static WebElement getElement(By elementLocator) {
		return driver.findElement(elementLocator);
	}
	
	public static WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getLocator(locatorType, locatorValue));
	}
	
	public static void type(By elementLocator, String text) {
		getElement(elementLocator).sendKeys(text);
	}
	
	public static void type(String locatorType, String locatorValue, String text) {
		getElement(locatorType, locatorValue).sendKeys(text);
	}
	
	public static void clickOnTheElement(By elementLocator) {
		getElement(elementLocator).click();
	}
	
	public static void clickOnTheElement(String locatorType, String locatorValue) {
		getElement(locatorType, locatorValue).click();
	}
	
	public static By getLocator(String locatorType, String locatorValue) {
		By locator = null;
		
		switch (locatorType.toUpperCase().trim()) {
		case "ID":
			locator = By.id(locatorValue);
			break;
		case "NAME":
			locator = By.name(locatorValue);
			break;
		case "CLASS_NAME":
			locator = By.className(locatorValue);
			break;
		case "XPATH":
			locator = By.xpath(locatorValue);
			break;
		case "CSS":
			locator = By.cssSelector(locatorValue);
			break;
		case "LINK_TEXT":
			locator = By.linkText(locatorValue);
			break;
		case "PARTIAL_LINK_TEXT":
			locator = By.partialLinkText(locatorValue);
			break;
		case "TAG_NAME":
			locator = By.tagName(locatorValue);
			break;
		default:
			System.out.println("Invalid locator..");
			break;
		}
		
		return locator;
	}
}

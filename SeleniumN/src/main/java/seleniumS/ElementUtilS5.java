package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtilS5 {
	
	private WebDriver driver;
	
	public ElementUtilS5(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(By elementLocator) {
		return driver.findElement(elementLocator);
	}
	
	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getLocator(locatorType, locatorValue));
	}
	
	public void type(By elementLocator, String text) {
		getElement(elementLocator).sendKeys(text);
	}
	
	public void type(String locatorType, String locatorValue, String text) {
		getElement(locatorType, locatorValue).sendKeys(text);
	}
	
	public void clickOnTheElement(By elementLocator) {
		getElement(elementLocator).click();
	}
	
	public void clickOnTheElement(String locatorType, String locatorValue) {
		getElement(locatorType, locatorValue).click();
	}
	
	public String getElementText(By elementLocator) {
		return getElement(elementLocator).getText();
	}
	
	public String getElementText(String locatorType, String locatorValue) {
		return getElement(locatorType, locatorValue).getText();
	}
	
	public By getLocator(String locatorType, String locatorValue) {
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
	
	public boolean isElementDisplayed(By elementLocator) {
		return getElement(elementLocator).isDisplayed();
	}

}

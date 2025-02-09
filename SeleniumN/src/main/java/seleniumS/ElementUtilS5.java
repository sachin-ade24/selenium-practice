package seleniumS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtilS5 {
	
	private WebDriver driver;
	
	public ElementUtilS5(WebDriver driver) {
		this.driver = driver;
	}
	
	private void nullCheck(CharSequence... value) {
		if(value==null) {
			throw new RuntimeException("==*value cannot be NULL*==");
		}
	}
	
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public WebElement getChildElement(By locator1, By locator2) {
		return getElement(locator1).findElement(locator2);
	}
	
	public List<WebElement> getChildElements(By locator1, By locator2) {
		return getElement(locator1).findElements(locator2);
	}
	
	public WebElement getElement(String locatorType, String locatorValue) {
		return driver.findElement(getLocator(locatorType, locatorValue));
	}
	
	public void type(By locator, CharSequence... text) {
		nullCheck(text);
		getElement(locator).sendKeys(text);
	}
	
	/*locatorType ==> Attribute; locatorValue ==> Attribute Value*/
	public void type(String locatorType, String locatorValue, CharSequence... text) {
		nullCheck(text);
		getElement(locatorType, locatorValue).sendKeys(text);
	}
	
	public void clickOnTheElement(By elementLocator) {
		getElement(elementLocator).click();
	}
	
	/*locatorType ==> Attribute; locatorValue ==> Attribute Value*/
	public void clickOnTheElement(String locatorType, String locatorValue) {
		getElement(locatorType, locatorValue).click();
	}
	
	public String getElementText(By elementLocator) {
		return getElement(elementLocator).getText();
	}
	
	/*locatorType ==> Attribute; locatorValue ==> Attribute Value*/
	public String getElementText(String locatorType, String locatorValue) {
		return getElement(locatorType, locatorValue).getText();
	}
	
	public String getElementAttribute(By locator, String attrName) {
		nullCheck(attrName);
		return getElement(locator).getDomAttribute(attrName);
	}
	
	public String getElementProperty(By locator, String propName) {
		nullCheck(propName);
		return getElement(locator).getDomProperty(propName);
	}
	
	/*Following method uses the isDisplayed() method with locator*/
	/*
	  try to avoid to utilize the following method
	  because, it will throw NoSuchElementException, 
	  in case the element is not available on the page.
	*/
	public boolean isAnElementDisplayed(By elementLocator) {
		return getElement(elementLocator).isDisplayed();
	}
	
	/*Following method returns a list of WebElements*/
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public boolean isElementDisplayedAtLeastOnce(By locator) {
		if(getElements(locator).size() == 1) {
			System.out.println("Element is displayed on the page.");
			return true;
		}else {
			System.out.println("Element is not displayed on the page.");
			return false;
		}
	}
	
	public boolean areElementsDisplayed(By locator, int elementCount) {
		if(getElements(locator).size() == elementCount) {
			System.out.println("Element is displayed on the page for " + elementCount);
			return true;
		}else {
			System.out.println("Element is not displayed on the page.");
			return false;
		}
	}
	
	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		}catch(NoSuchElementException e){
			System.out.println("Element is not displayed.");
			return false;
		}
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
	
}

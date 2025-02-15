package seleniumS;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	/*===========================Wait-Utils===========================*/
	/**
	 * An expectation for checking that an element is present on the DOM of a page. 
	 * This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	/*Web page: element either visible or hidden on the page/UI.
	 *DOM: element is always present on the DOM of a page.
	 * */
	public WebElement waitForAllTheElement(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible. 
	 * Visibility means that the element is not only displayed but also has a height and width 
	 * that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public WebElement waitForTheVisibleElement(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * An expectation for checking an element is visible and enabled 
	 * such that you can click it.
	 * @param locator
	 * @param timeOut
	 */
	public void clickElementWhenVisibleAndEnabled(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	/**
	 * An expectation for checking an element is visible and enabled 
	 * such that you can click it.
	 * @param element
	 * @param timeOut
	 */
	public void clickElementWhenVisibleAndEnabled(WebElement element, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	/**
	 * An expectation for checking that the title contains a case-sensitive substring.
	 * @param partialTitle
	 * @param timeOut
	 * @return
	 */
	public String waitForTheTitleByPassingFractionTitle(String fractionTitle, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.titleContains(fractionTitle))) {
				return driver.getTitle();
			}
		} catch(TimeoutException e) {
			System.out.println("The title is not found even after " + timeOut + " seconds.");
		}
	    return null;
	}
	
	/**
	 * An expectation for checking the title of a page.
	 * @param title
	 * @param timeOut
	 * @return
	 */
	public String waitForTheTitle(String title, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.titleIs(title))) {
				return driver.getTitle();
			}
		} catch(TimeoutException e) {
			System.out.println("The title is not found even after " + timeOut + " seconds.");
		}
	    return null;
	}
	
	/**
	 * An expectation for the URL of the current page to contain specific text.
	 * @param fractionUrl
	 * @param timeOut
	 * @return
	 */
	public String waitForUrlByPassingFractionUrl(String fractionUrl, long timeOut) {
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.urlContains(fractionUrl))){
				return driver.getCurrentUrl();
			}
		} catch(TimeoutException e){
			System.out.println("The URL is not found even after " + timeOut + " seconds.");
		}
		return null;
	}
	
	/**
	 * An expectation for the URL of the current page to be a specific URL.
	 * @param url
	 * @param timeOut
	 * @return
	 */
	public String waitFortheUrl(String url, long timeOut) {
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			if(wait.until(ExpectedConditions.urlToBe(url))) {
				return driver.getCurrentUrl();
			}
		}catch(TimeoutException e) {
			System.out.println("The title is not found even after " + timeOut + " seconds.");
		}
		return null;
	}
	
	/*Wait for Alert*/
	/**
	 * Waiting for alert
	 * @param timeOut
	 * @return
	 */
	public Alert waitForAlert(long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	/**
	 * Getting alert text
	 * @param timeOut
	 * @return
	 */
	public String getAlertText(long timeOut) {
		return waitForAlert(timeOut).getText();
	}
	
	/**
	 * Accept the alert
	 * @param timeOut
	 */
	public void acceptAlert(long timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	/**
	 * Dismiss or reject the alert
	 * @param timeOut
	 */
	public void rejectAlert(long timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	/**
	 * Type in the alert
	 * @param text
	 * @param timeOut
	 */
	public void typeInAlert(String text, long timeOut) {
		waitForAlert(timeOut).sendKeys(text);
	}
	
	/*Wait for iFrame*/
	/**
	 * An expectation for checking whether the given frame is available to switch to. 
	 * If the frame is available it switches the given driver to the specified frame.
	 * @param frameLocator
	 * @param timeOut
	 */
	public void waitForFrameUsingFrameByLocator(By frameLocator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	/**
	 * An expectation for checking whether the given frame is available to switch to. 
	 * If the frame is available it switches the given driver to the specified frameIndex.
	 * @param frameIndex
	 * @param timeOut
	 */
	public void waitForFrameUsingFrameIndex(int frameIndex, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	/**
	 * An expectation for checking whether the given frame is available to switch to. 
	 * If the frame is available it switches the given driver to the specified frame.
	 * @param frameNameOrId
	 * @param timeOut
	 */
	public void waitForFrameUsingFrameNameOrId(String frameNameOrId, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
	}
	
	/**
	 * An expectation for checking whether the given frame is available to switch to. 
	 * If the frame is available it switches the given driver to the specified web element.
	 * @param frameWebElement
	 * @param timeOut
	 */
	public void waitForFrameUsingFrameWebElement(WebElement frameWebElement, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameWebElement));
	}
	
	/*Wait for Window*/
	/**
	 * Checking expected number of windows with actual number of windows
	 * @param numberOfWindows
	 * @param timeOut
	 * @return
	 */
	public boolean waitForWindow(int numberOfWindows, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			return wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
		}catch(TimeoutException e) {
			System.out.println("Number of windows are not matched...");
			return false;
		}
	}
	
	/**
	 * An expectation for checking that there is at least one element 
	 * present on a web page.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForWebElementsPresence(By locator, long timeOut){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	/**
	 * An expectation for checking that all elements present on the web page that match 
	 * the locator are visible. 
	 * Visibility means that the elements are not only displayed 
	 * but also have a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	public List<WebElement> waitForVisibleWebElements(By locator, long timeOut){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
}

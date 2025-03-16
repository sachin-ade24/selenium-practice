package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Basics {
	
	static WebDriver driver;
	static Actions act;

	public static void main(String[] args){
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://www.google.com");
		//String currentUrl = driver.getCurrentUrl();
		//System.out.println("Current URL: " + currentUrl);
		
		//WebElement search = driver.findElement(By.cssSelector("textarea[aria-label='Search']"));
		//search.click();
		//search.sendKeys("Sauce Demo" + Keys.ENTER);
		
		driver.navigate().to("https://www.saucedemo.com/v1/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		By userName = By.id("user-name");
		By password = By.id("password");
		By loginBtn = By.xpath("//input[@id='login-button']");
		
		//General methods (without Actions)
		//type(userName, "standard_user");
		//type(password, "secret_sauce");
		//clickOnElement(loginBtn);
		
		//Actions:
		typeAction(userName, "standard_user");
		typeAction(password, "secret_sauce");
		clickAction(loginBtn);
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);
		
		//JavaScript Executor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String currentURL = js.executeScript("return document.URL;").toString();
		System.out.println("Current URL: " + currentURL);
		String currentTitle = js.executeScript("return document.title;").toString();
		System.out.println("Current Title: " + currentTitle);
		
		By backpackLocator = By.xpath("//div[contains(text(), 'Backpack')]");
		WebElement backpack = driver.findElement(backpackLocator);
		System.out.println("Clicked on " + backpack.getText());
		js.executeScript("arguments[0].scrollIntoView(true);", backpack);
		js.executeScript("arguments[0].click();", backpack);
		js.executeScript("return history.go(-1);");
		
		//product_sort_container
		//By sortContainer =  By.className("product_sort_container");
		//WebElement sortContainerElement = driver.findElement(sortContainer);
		//Select select = new Select(sortContainerElement);
		
		//select and deselect
		//select.selectByVisibleText("Name (A to Z)");
		//select.selectByValue("za");
		//select.selectByIndex(2);
		//select.selectByContainsVisibleText("high to low");
		
		//selectElementByValue("za");
		
		By containerElement =  By.xpath("//select/option");
		List<WebElement> sortContainerElements = driver.findElements(containerElement);
		for(WebElement e: sortContainerElements) {
			System.out.println(e.getText());
		}
		
		quitAndCloseAllWindows();
	}
	
	public static void selectElementByValue(String value) {
		By containerElement =  By.xpath("//select");
		WebElement sortContainerElement = driver.findElement(containerElement);
		Select select = new Select(sortContainerElement);
		select.selectByValue(value);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void type(By locator, String text) {
		getElement(locator).sendKeys(text);
	}

	public static void clickOnElement(By locator) {
		getElement(locator).click();
	}
	
	public static void clickAction(By locator) {
		act =  new Actions(driver);
		act.moveToElement(getElement(locator)).click(getElement(locator)).build().perform();
	}
	
	public static void typeAction(By locator, String text) {
		act =  new Actions(driver);
		act.moveToElement(getElement(locator)).sendKeys(getElement(locator), text).build().perform();
	}
	
	/**
	 * Close the current window, quitting the browser if it's the last window currently open. 
	 */
	public static void closeCurrentWindow() {
		driver.close();
	}
	
	/**
	 * Quits this driver, closing every associated window. 
	 */
	public static void quitAndCloseAllWindows() {
		driver.quit();
	}
	
}

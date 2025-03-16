package seleniumS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S15ActionsMoveToElement {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//WebElement addOnsElement = driver.findElement(By.xpath("//div[contains(text(), 'Add-ons')]"));
		
		//Actions action = new Actions(driver);
		
		//action.moveToElement(addOnsElement).perform();
		
		//WebElement visaServicesEle;
		
		//try {
		//	visaServicesEle = driver.findElement(By.xpath("//div[contains(text(), 'Visa Services')]"));
		//	action.moveToElement(visaServicesEle).click(visaServicesEle).build().perform();
		//} catch(NoSuchElementException e) {
		//	System.out.println("NSE is coming.. element does not exist..");
		//	e.printStackTrace();
		//}
		
		By addOns = By.xpath("//div[contains(text(), 'Add-ons')]");
		By visaServices = By.xpath("//div[contains(text(), 'Visa Services')]");
		twoLevelMenuHandlingAction(addOns, visaServices);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void twoLevelMenuHandlingAction(By firstMenuLevelLocator, By secondLevelMenuLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getElement(firstMenuLevelLocator)).perform();
		action.moveToElement(getElement(secondLevelMenuLocator)).click(getElement(secondLevelMenuLocator)).build().perform();
	}

}

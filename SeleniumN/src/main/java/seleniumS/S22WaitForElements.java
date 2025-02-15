package seleniumS;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S22WaitForElements {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		By footer =  By.xpath("//footer//a");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//An expectation for checking that there is at least one element present on a web page.
		List<WebElement> footerElementList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(footer));
		//List<WebElement> footerElementList = waitForWebElements(footer, 10);
		
		//An expectation for checking that all elements present on the web page 
		//that match the locator are visible. Visibility means that the elements are 
		//not only displayed but also have a height and width that is greater than 0.
		List<WebElement> visibleFooterElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer));
		
		System.out.println("Umber of footer elements: " + footerElementList.size());
		for(WebElement e : footerElementList) {
			System.out.println(e.getText());
		}
		
		System.out.println(visibleFooterElements.size());
		for(WebElement e : visibleFooterElements) {
			System.out.println(e.getText());
		}
		
	}
	
	public static List<WebElement> waitForWebElementsPresence(By locator, long timeOut){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public static List<WebElement> waitForVisibleWebElements(By locator, long timeOut){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
}

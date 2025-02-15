package seleniumS;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S22WaitForWindow {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		By OrangeHRMLink = By.xpath("//a[@href='/en/company/about-us' and contains(text(), 'OrangeHRM')]");
		
		Actions action = new Actions(driver); 
		action.moveToElement(driver.findElement(OrangeHRMLink)).build().perform();
		
		ElementUtilS5 eleUtil = new ElementUtilS5(driver);
		eleUtil.clickElementWhenVisibleAndEnabled(OrangeHRMLink, 10);
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		if(waitForWindow(2, 10)) {
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> itrt = handles.iterator();
			
			String parentWindowId = itrt.next();//for parent window
			System.out.println(parentWindowId);
			
			String childWindow =  itrt.next();//for child window
			System.out.println(childWindow);
			
			//switching window:
			driver.switchTo().window(childWindow);
			System.out.println(driver.getTitle());
			
			//close child window
			driver.close();
			
			//now driver is lost
			//switch back to parent window
			driver.switchTo().window(parentWindowId);
			System.out.println(driver.getTitle());
		}
		
		driver.quit();

	}
	
	public static boolean waitForWindow(int numberOfWindows, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		try {
			return wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
		}catch(TimeoutException e) {
			System.out.println("Number of windows are not matched...");
			return false;
		}
	}

}

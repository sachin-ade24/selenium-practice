package seleniumS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S21WaitForTitleAndUrl {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		//1. Title
		//driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		//String title = driver.getTitle();
		//System.out.println(title);
		//if you see 'loading...'
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.titleIs("Register Account"));//valid
		//wait.until(ExpectedConditions.titleContains("Register"));//valid
		//if(wait.until(ExpectedConditions.titleContains("Register"))) {
		//	System.out.println(driver.getTitle());
		//}
		
		//2. URL
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		driver.findElement(By.linkText("Privacy Policy.")).click();
		String currentURL = waitForUrlByPassingFractionUrl("OrangeHRM-Privacy-Policy.pdf", 5);
		System.out.println(currentURL);
	}
	
	public static String waitForUrlByPassingFractionUrl(String fractionUrl, long timeOut) {
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
	
	public static String waitFortheUrl(String url, long timeOut) {
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
	
	public static String waitForTheTitleByPassingFractionTitle(String fractionTitle, long timeOut) {
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
	
	public static String waitForTheTitle(String title, long timeOut) {
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


}

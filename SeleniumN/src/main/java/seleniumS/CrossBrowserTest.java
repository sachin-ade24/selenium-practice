package seleniumS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTest {
	
	static WebDriver driver;// for static, no need to create Object now
    //because this is common property for all browsers
	//if we don't use static WebDriver the we have to create Object for 
	//all browsers
	
	public static void main(String[] args) {
		
		String browser = "chrome";
		
		switch (browser.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "safari":
			driver = new SafariDriver();
			break;
		default:
			System.out.println("please pass the valid browser..");
			throw new RuntimeException("==Invalid browser==");
		}
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String title = driver.getTitle();
		if(title.equals("Account Login")) {
			System.out.println("Title is correct.. test PASSED");
		} else {
			System.out.println("Title is wrong.. test FAILED");
		}
		
		String currentURL = driver.getCurrentUrl();
		if(currentURL.contains("route=account/login")) {
			System.out.println("URL is correct.. test PASSED..");
		} else {
			System.out.println("URL is wrong.. test FAILED..");
		}
		
		driver.quit();

	}

}

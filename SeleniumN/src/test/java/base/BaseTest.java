package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;
	
	@Parameters({"url", "browser"})
	@BeforeTest
	public void setup(String url, String browserName) {
		
		System.out.println("Browser name: " + browserName);
		switch (browserName.trim().toLowerCase()) {
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
			System.out.println("Please pass the valid browser.");
			throw new RuntimeException("=*=*INVALID BROWSER*=*=");
		}
		
		//Delete all the cookies for the current domain. 
		driver.manage().deleteAllCookies();
		
		//manage(): Gets the Option interface
		/* An interface for managing stuff you would do in a browser menu */
		//timeouts(): the interface for managing driver timeouts.
		//implicitlyWait(): Specifies the amount of time the driver should wait 
		//when searching for an element if it is not immediately present. 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//window(): The interface for managing the current window.
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}

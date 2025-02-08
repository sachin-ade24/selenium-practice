package seleniumS;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserUtilS4 {
	
	WebDriver driver;
	
	public WebDriver initDriver(String browser) {
		System.out.println("Browser: " + browser);
		
		switch(browser.trim().toLowerCase()) {
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
			throw new RuntimeException("==*Invalid Browser*==");
		}
		
		return driver;
	}
	
	public void launchTheUrl(String url) {
		if(url==null) {
			throw new RuntimeException("==*URL cannot be NULL*==");
		}
		if(url.length()==0 || url.isBlank()) {
			throw new RuntimeException("==*URL cannot be BLANK or Empty*==");
		}
		if(url.startsWith("http")) {
			driver.get(url);
		}else {
			throw new RuntimeException("==*please provide proper URL with 'http/s'*==");
		}
	}
	
	public void launchTheUrl(URL url) {
		if(url==null) {
			throw new RuntimeException("==*URL cannot be NULL*==");
		}
		if(String.valueOf(url).length()==0 || String.valueOf(url).isBlank()) {
			throw new RuntimeException("==*URL cannot be BLANK or Empty*==");
		}
		if(String.valueOf(url).startsWith("http")) {
			driver.navigate().to(url);
		}else {
			throw new RuntimeException("==*please provide proper URL with 'http/s'*==");
		}
	}
	
	
	public String getPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Current URL: " + url);
		return url;
	}
	
	public String getPageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
		return title;
	}

	public void closeTheBrowser() {
		System.out.println("Closing the browser..");
		driver.close();
	}
	
	public void quitTheBrowser() {
		System.out.println("Quitting browser..");
		driver.quit();
	}
}

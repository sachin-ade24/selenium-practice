package seleniumS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class S20NewBrowserWindow {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String parentWindowId = driver.getWindowHandle();
		
		//new tab
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://google.com");
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getCurrentUrl());
		
		//New window
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://google.com");
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getCurrentUrl());

	}

}

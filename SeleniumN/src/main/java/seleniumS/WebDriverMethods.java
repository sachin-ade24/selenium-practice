package seleniumS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods {

	public static void main(String[] args) {
		
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		String title = driver.getTitle();
		String currentURL = driver.getCurrentUrl();
		String pageSource = driver.getPageSource();
		//prints complete DOM body on the console
		System.out.println(pageSource);
		if(pageSource.contains("Account Login")) {
			System.out.println("PASSED..");
		} else {
			System.err.println("failed..");
		}

	}

}

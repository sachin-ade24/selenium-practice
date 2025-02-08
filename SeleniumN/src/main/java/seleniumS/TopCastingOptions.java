package seleniumS;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TopCastingOptions {

	public static void main(String[] args) {
		
		//top casting options:
		
		//0th:
		//valid but not recommended
		//because this can be used only for GoogleChrome
		//and this is not top casting
		//we are just creating Object of ChromeDriver
		//ChromeDriver driver =  new ChromeDriver();
		
		//1. valid and recommended:
		//WebDriver driver = new ChromeDriver();
	  /*Interface ObjectName = new ChildClass();*/
		//driver.get("https://google.com");
		
		//2. SearchContext Obj with ChromeDriver:
		//valid but not recommended at all
		//reason: we can only access or implement two methods
		//findElement and findElements from the SearchContext
		//rest of the methods cannot be used by sing 'driver' reference
		//SearchContext driver =  new ChromeDriver();
		//driver.get("https://google.com");
		
		//3. RemoteWebDriver Obj with ChromeDriver:
		//valid and recommended 
		//RemoteWebDriver driver =  new ChromeDriver();
		//driver.get("https://google.com");
		
		//4. valid and recommended
		//Can be used with remote machine -- Selenium grid, docker, cloud, SauceLabs etc.
		//WebDriver driver = new RemoteWebDriver(remoteAddress, capabilities)
		
		//5. SearchContext ==> RemoteWebDriver
		//valid but not recommended at all
		//reason: we can only access or implement two methods
		//findElement and findElements from the SearchContext
		//rest of the methods cannot be used by sing 'driver' reference
		//SearchContext driver =  new RemoteWebDriver(remoteAddress, capabilities);
		
		//6. ChromiumDriver ==> ChromeDriver
		//valid but not recommended
		//reason: only two browser can be used with ChromiumDriver
		//we can use only edge and GoogleChrome
		//ChromiumDriver driver =  new ChromeDriver();
		
		
		/* following are best options:
		 * 1. WebDriver driver ==> ChromeDriver
		 * 
		 * 4. WebDriver driver ==> RemoteWebDriver
		 * */
		
	}

}

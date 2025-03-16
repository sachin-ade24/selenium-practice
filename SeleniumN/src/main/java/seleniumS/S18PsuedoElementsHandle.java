package seleniumS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S18PsuedoElementsHandle {

	public static void main(String[] args) {
		
		//::before
		//::after
		//::has
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		String script = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content')";
		
		
		/**
		 * Type Casting ((JavascriptExecutor) driver):
		 * Selenium WebDriver does not implement JavascriptExecutor directly. 
		 * Instead, browser-specific driver classes (e.g., ChromeDriver, FirefoxDriver) implement it.
		 * Since driver is declared as WebDriver, 
		 * you need to cast it to JavascriptExecutor before using JavaScript execution methods.
		 * This ensures that js can access JavaScript execution methods like .executeScript() 
		 * and .executeAsyncScript().
		 */
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		String content = js.executeScript(script).toString();
		System.out.println(content);//"* "
		
	}

}

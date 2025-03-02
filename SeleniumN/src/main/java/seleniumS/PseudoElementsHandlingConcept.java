package seleniumS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElementsHandlingConcept {

	public static void main(String[] args) {
		
		// ::before --> Pseudo Element/Pseudo class
		// ::after --> Pseudo Element
		// ::has --> Pseudo Element
		
		WebDriver driver =  new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		String script = "return window.getComputedStyle(document.querySelector(\"[for='input-firstname']\"), '::before').getPropertyValue('content');";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String psuedoElementText = js.executeScript(script).toString();
		System.out.println(psuedoElementText);
		if(psuedoElementText.contains("*")) {
			System.out.println("First name is a mandatory field.");
		}
		
	}

}

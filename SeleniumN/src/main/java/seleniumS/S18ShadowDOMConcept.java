package seleniumS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S18ShadowDOMConcept {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//To target an element under the Shadow-DOM, we need to use JavascriptExecutor
		//Use JS Path:
		//Go to the page where your element is present. Right click and inspect.
		//Take cursor over the element you want to target and again right click on it.
		//click on the 'Copy' option or move cursor on copy option and click on 'Copy JS Path'. 
		//Open the console and clear it and paste the copied JS Path.
		
		//JS Path:
		//document.querySelector("#userName").shadowRoot.querySelector("#app2").shadowRoot.querySelector("#pizza")
		
		String jsPath = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#app2\").shadowRoot.querySelector(\"#pizza\");"; 
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement pizza = (WebElement) js.executeScript(jsPath);//Casting
		//Casting for: converting JavaScript object into WebElement
		
		pizza.sendKeys("My Pizza");
		
		String jsPathForIframe = "return document.querySelector('#userName').shadowRoot.querySelector('#pact1');";
		WebElement iframeElement = (WebElement) js.executeScript(jsPathForIframe);
		
		driver.switchTo().frame(iframeElement);
		
		String jsPathForDestiny = "return document.querySelector('#glaf');";
		WebElement destinyElement = (WebElement) js.executeScript(jsPathForDestiny);
		
		destinyElement.sendKeys("Shanti");
		
		
	}

}

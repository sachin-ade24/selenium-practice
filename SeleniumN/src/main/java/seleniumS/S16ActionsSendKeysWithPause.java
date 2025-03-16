package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S16ActionsSendKeysWithPause {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By search = By.cssSelector("[placeholder='Search']");
		//WebElement searchEle = driver.findElement(By.cssSelector("[placeholder='Search']")); 
		//Actions act =  new Actions(driver);
		
		String product = "macbook";
		
		//char prouctChars[] = product.toCharArray();
		
		//for(char productChar: prouctChars) {
		//	act.sendKeys(searchEle, String.valueOf(productChar))
		//		.pause(700)
		//			.perform();
		//}
		
		typeActionWithPause(product, search, 700);

	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void typeActionWithPause(String text, By locator, long pauseTime) {
		Actions act =  new Actions(driver);
		
		char textChars[] = text.toCharArray();
		
		for(char textChar: textChars) {
			act.sendKeys(getElement(locator), String.valueOf(textChar))
				.pause(pauseTime)
					.perform();
		}
	}

}

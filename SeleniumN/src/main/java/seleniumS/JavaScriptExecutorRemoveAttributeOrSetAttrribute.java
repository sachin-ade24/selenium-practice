package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptExecutorRemoveAttributeOrSetAttrribute {
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		WebElement facebook = driver.findElement(By.cssSelector("[href='https://www.facebook.com/OrangeHRM']"));
		Actions act = new Actions(driver);
		act.moveToElement(facebook).perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//Remove the 'target="_blank"' attribute. After removing it, if you click on the
		//element, it will open the new tab in the same tab.
		js.executeScript("arguments[0].removeAttribute('target');", facebook);
		js.executeScript("arguments[0].click();", facebook);
		
		js.executeScript("return history.go(-1);");
		
		//Change the value of 'target' attribute from '_blank' to '_self'
		WebElement youTube = driver.findElement(By.cssSelector("[href='https://www.youtube.com/user/orangehrm']"));
		//Change the value of the attribute
		js.executeScript("arguments[0].setAttribute('target', '_self')", youTube);
		js.executeScript("arguments[0].click();", youTube);
	}

}

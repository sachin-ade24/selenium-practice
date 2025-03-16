package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S16ActionsScrolling {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		Actions act =  new Actions(driver);
		
		//Approach 1: Partial scrolling
		//act.sendKeys(Keys.PAGE_DOWN).perform();	
		//act.pause(2000);
		//act.sendKeys(Keys.PAGE_UP).perform();
		
		//Approach 2:
		//Scroll to footer
		//act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		//act.pause(2000);
		//Scroll to top
		//act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		
		//Scroll to element:
		act.scrollToElement(driver.findElement(By.xpath("//a[text()='OpenCart']")))
			.pause(1000)
				.click(driver.findElement(By.xpath("//a[text()='OpenCart']")))
					.build()
						.perform();
		
	}

}

package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class S16ActionsMethodChaining {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By firstName = By.cssSelector("#input-firstname");
		WebElement firstNameEle = driver.findElement(firstName);
		
		Actions act = new Actions(driver);
		
		Action buildAction = act.moveToElement(firstNameEle)
			.sendKeys(firstNameEle, "Sachin")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("Ade")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("sachin@abc.com")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("9090909090")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("S@Ade24Feb")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys("S@Ade24Feb")
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.SPACE)
			.pause(500)
			.sendKeys(Keys.TAB)
			.pause(500)
			.sendKeys(Keys.ENTER)
			.build();
		
		buildAction.perform();
	}

}

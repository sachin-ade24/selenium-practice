package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S15ActionsClickAndSendKeys {

		static WebDriver driver;

		public static void main(String[] args) {
			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

			By firstName = By.cssSelector("#input-firstname");
			WebElement firstNameEle = driver.findElement(firstName);
			
			Actions action = new Actions(driver);
			action.moveToElement(firstNameEle).sendKeys(firstNameEle, "Sachin").build().perform();
			
			ElementUtilS5 obj = new ElementUtilS5(driver);
			By register = By.xpath("(//li/a[text()='Register'])[last()]");
			By lastName = By.cssSelector("#input-lastname");
			obj.clickAction(register);
			obj.typeAction(firstName, "Sachin");
			obj.typeAction(lastName, "Ade");
	}

}

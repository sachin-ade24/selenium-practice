package seleniumS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S21ExplicitWait {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		By firstName = By.id("input-firstname");
		By lastName = By.id("input-lastname");
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement firstName_ele = wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
		//firstName_ele.sendKeys("Sachin");
		
		//first element
		waitForTheElement(firstName, 10).sendKeys("Sachin");
		//second element
		driver.findElement(lastName).sendKeys("Ade");
		
	}
	
	public static WebElement waitForTheElement(By locator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}

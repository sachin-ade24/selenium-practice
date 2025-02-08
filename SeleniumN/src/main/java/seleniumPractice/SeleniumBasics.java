package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumBasics {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		// CromeDriver: is a Class
		// driver: reference name
		// Info: A WebDriver implementation that controls a 'Chrome' browser 
		// running on the local machine.
		// It requires a 'chromedriver' executable to be available in PATH.
		// new ChromeDriver() ==> Object reference
		// new ==> Keyword for creating a new instance/Object
		// ChromeDriver() ==> Constructor of ChromeDriver Class with no argument
		
		
		
		driver.manage().window().maximize();
		// manage() ==> Option interface 
		// Info: Returns an option interface
		// window() ==> Interface 
		// Info: Returns the interface for managing the current window.
		// maximize() ==> void method
		// Info: Returns the interface for managing the current window.
		
		
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");// Allowed and its a void method
		// driver.get("https://google.com");// Allowed
		// driver.get("www.google.com");// Not allowed
		// Exception: InvalidArgumentException
		// driver.get("google.com");// Not allowed
		// Exception: InvalidArgumentException
		
		
		
		String actualTitle = driver.getTitle();// returns String, so you can save this into a String
		System.out.println("Title is: " + actualTitle);
		
		// Assertion
		if(actualTitle.equals("Google")) {
			System.out.println("PASS");
		} else {
			System.err.println("FAIL");
		}
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.DOWN).build().perform();
		
		WebElement dropdown = driver.findElement(By.id("dropdownId"));
		
		By firstName = By.id("id");
		
		Select sel =  new Select(dropdown);
		
		
		driver.switchTo().alert();
		driver.switchTo().frame(0);
		driver.switchTo().frame("nameOrId");
		driver.switchTo().frame("WebElement ele");
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();
		
		//
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		System.out.println(title);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement firstName_ele = wait.until(ExpectedConditions.presenceOfElementLocated(firstName));
		firstName_ele.click();
		
		WebElement firstName_ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
		firstName_ele1.click();
		
		driver.quit();// void method
		
	}

}

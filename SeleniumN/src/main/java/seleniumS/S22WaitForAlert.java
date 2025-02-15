package seleniumS;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S22WaitForAlert {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		By text = By.xpath("//button[text()='Click for JS Alert']");
		WebElement alertEle =  driver.findElement(text);
		alertEle.click();
		//driver.switchTo().alert().accept();//valid: general flow
		//driver.switchTo().alert().dismiss();//valid: general flow
		//Alert alrt = driver.switchTo().alert();//valid: general flow
		//alrt.accept();//valid: general flow
		//alrt.dismiss();//valid: general flow
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		
	}
	
	public static Alert waitForAlert(long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String getAlertText(long timeOut) {
		return waitForAlert(timeOut).getText();
	}
	
	public static void acceptAlert(long timeOut) {
		waitForAlert(timeOut).accept();
	}
	
	public static void rejectAlert(long timeOut) {
		waitForAlert(timeOut).dismiss();
	}
	
	public static void typeInAlert(String text, long timeOut) {
		waitForAlert(timeOut).sendKeys(text);
	}

}

package seleniumS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class S22WaitForFrame {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver =  new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		
		//Not working:
		//WebElement iFrameWebEle = driver.findElement(By.xpath("//div[@id='imageTemplateContainer']"));
		//Actions action = new Actions(driver);
		//action.moveToElement(iFrameWebEle);
		//driver.switchTo().frame(iFrameWebEle);
		//String h1Text = driver.findElement(By.xpath("//div[@id='imageTemplateContainer']")).getText();
		//System.out.println(h1Text);
		
		By formImage = By.cssSelector("#imageTemplateContainer > img");
		By frameLocator = By.xpath("//iframe[contains(@id, 'frame-one')]");
		By firstName = By.cssSelector("#q8 > input");
		By lastName = By.cssSelector("#q9 > input");
		
		ElementUtilS5 eleUtil = new ElementUtilS5(driver);
		eleUtil.waitForTheVisibleElement(formImage, 10).click();
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
		//waitForIframe(frameLocator, 10);
		//wait for this element only
		//driver.findElement(By.cssSelector("#q8 > input")).sendKeys("Title 1");
		//eleUtil.waitForTheVisibleElement(firstName, 10).sendKeys("Sachin");
		//Now, no need to wait for second element here
		//eleUtil.type(lastName, "Ade");
		//typeForIframe(frameLocator, lastName, "Ade", 10);
		
		waitForFrameUsingByLocator(frameLocator, 10);
		eleUtil.type(lastName, "Ade");
		
		driver.switchTo().defaultContent();
		WebElement h3Title = driver.findElement(By.cssSelector("h3.details__form-preview-title"));
		String h3TitleText = h3Title.getText();
		System.out.println(h3TitleText);
		
	}
	
	public static void waitForFrameUsingByLocator(By frameLocator, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}
	
	public static void waitForFrameUsingByLocator(int frameIndex, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
	}
	
	public static void waitForFrameUsingByLocator(String frameNameOrId, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
	}
	
	public static void waitForFrameUsingByLocator(WebElement frameWebElement, long timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameWebElement));
	}
	
//	public static WebDriver waitForFrameUsingByLocator(By frameLocator, long timeOut) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
//	}
	
//	public static void typeForIframe(By frameLocator, By eleLocator, String text,long timeOut) {
//		waitForFrameUsingByLocator(frameLocator, timeOut).findElement(eleLocator).sendKeys(text);
//	}
	
	

}

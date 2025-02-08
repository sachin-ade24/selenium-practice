package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementClick {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");
		
		By fullName = By.id("Form_getForm_Name");
		By email = By.id("Form_getForm_Email");
		By contactNumber = By.id("Form_getForm_Contact");
		By getYourFreeTrial = By.id("Form_getForm_action_submitForm");
		
		By header = By.className("form-title");
		
		//String headerText = driver.findElement(header).getText();
		//System.out.println(headerText);
		System.out.println(getElementText(header));
		
		//driver.findElement(fullName).sendKeys("Sachin");
		type(fullName, "Sachin");
		//driver.findElement(email).sendKeys("sachin123@abc.com");
		type(email, "sachin123@abc.com");
		//driver.findElement(contactNumber).sendKeys("9009977900");
		type(contactNumber, "9009977900");
		//driver.findElement(getYourFreeTrial).click();
		clickOnTheElement(getYourFreeTrial);
		
		

	}
	
	public static String getElementText(By elementLocator) {
		return getElement(elementLocator).getText();
	}
	
	public static void clickOnTheElement(By elementLocator) {
		getElement(elementLocator).click();
	}
	
	public static WebElement getElement(By elementLocator) {
		return driver.findElement(elementLocator);
	}
	
	public static void type(By elementLocator, String text) {
		getElement(elementLocator).sendKeys(text);
	}

}

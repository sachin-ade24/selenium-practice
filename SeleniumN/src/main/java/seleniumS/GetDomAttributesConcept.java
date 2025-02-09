package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetDomAttributesConcept {
	
	static WebDriver driver; 

	public static void main(String[] args) {
		
		driver =  new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		WebElement emailIdEle = driver.findElement(By.id("input-email"));
		
		//String valueOfPlaceholder = emailIdEle.getDomAttribute("placeholder");
		//System.out.println(valueOfPlaceholder);
		//o/p: E-Mail Address
		
		By email_id = By.id("input-email");
		System.out.println(getElementAttribute(email_id, "placeholder"));
		
		//String outerHtmlVal = emailIdEle.getDomProperty("outerHTML");
		//System.out.println(outerHtmlVal);
		//o/p:
		//<input type="text" name="email" value="" placeholder="E-Mail Address" id="input-email" class="form-control">
		//
		System.out.println(getElementProperty(email_id, "outerHTML"));
		
		//
		emailIdEle.sendKeys("s@ba.com");
		//String emailValue = emailIdEle.getDomProperty("value");
		//System.out.println(emailValue);
		//
		System.out.println(getElementProperty(email_id, "value"));
		
		//
		WebElement passwordIdEle = driver.findElement(By.id("input-password"));
		passwordIdEle.sendKeys("@dmin123");
		//System.out.println(passwordIdEle.getDomProperty("value"));
		//
		By password_id = By.id("input-password");
		System.out.println(getElementProperty(password_id, "value"));

	}
	
	public static WebElement getElement(By elementLocator) {
		return driver.findElement(elementLocator);
	}
	
	public static String getElementAttribute(By elementLocator, String attributeName) {
		return getElement(elementLocator).getDomAttribute(attributeName);
	}
	
	public static String getElementProperty(By elementLocator, String propertyName) {
		return getElement(elementLocator).getDomProperty(propertyName);
	}

}

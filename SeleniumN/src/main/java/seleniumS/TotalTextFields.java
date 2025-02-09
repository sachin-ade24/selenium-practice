package seleniumS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalTextFields {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//driver.findElements(By.xpath("//input[@class='form-control']"));
		List<WebElement> allTextFields = driver.findElements(By.className("form-control"));
		System.out.println(allTextFields.size());//7
		
		//1. by className:
		//List<WebElement> textFieldsUnderFormTag = driver.findElement(By.className("form-horizontal")).findElements(By.className("form-control"));
		//System.out.println(textFieldsUnderFormTag.size());//6
		
		By l1 = By.className("form-horizontal");
		By l2 = By.id("input-firstname");
		By l3 = By.className("form-control");
		
		getChildElement(l1, l2).sendKeys("Sachin");
		
		System.out.println(getChildElements(l1, l3).size());//6
		
		//2. by XPath:
		//form(parent tagName)==>//input('//'->indirect child, 'input'->input child)
		List<WebElement> textFieldsUnderFormTag = driver.findElements(By.xpath("//form//input[@class='form-control']"));
		System.out.println(textFieldsUnderFormTag.size());//6
	}
	
	public static WebElement getChildElement(By locator1, By locator2) {
		return getElement(locator1).findElement(locator2);
	}
	
	public static WebElement getElement(By elementLocator) {
		return driver.findElement(elementLocator);
	}
	
	public static List<WebElement> getChildElements(By locator1, By locator2) {
		return getElement(locator1).findElements(locator2);
	}

}

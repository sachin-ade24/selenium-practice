package seleniumS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//s9
public class ElementIsDisplayed_IsDisabled_IsChecked {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		
		WebElement password_id = driver.findElement(By.id("pass"));
		WebElement firstNameEle = driver.findElement(By.id("fname"));
		
		
		boolean isDisplayed = password_id.isDisplayed();
		System.out.println(isDisplayed);//true
		
		boolean isEnabled = password_id.isEnabled();
		System.out.println(isEnabled);//false
		
		System.out.println(firstNameEle.isDisplayed());//true
		System.out.println(firstNameEle.isEnabled());//true
		
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement policyCheckbox = driver.findElement(By.name("agree"));
		System.out.println(policyCheckbox.isSelected());//false
		policyCheckbox.click();
		System.out.println(policyCheckbox.isSelected());//true
		
	    List<WebElement> hrefLinks = driver.findElement(By.tagName("footer")).findElements(By.tagName("a"));
	    for(WebElement e : hrefLinks) {
	    	System.out.println(e.getDomAttribute("href"));
	    }
		
	}

}

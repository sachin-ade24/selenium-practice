package seleniumS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterLinks {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		ElementUtilS5 eleUtil =  new ElementUtilS5(driver);
		By locator1 = By.tagName("footer");
		By locator2 = By.tagName("h5");
		By locator3 = By.tagName("a");
		
		List<WebElement> h5ListForFooter= eleUtil.getChildElements(locator1, locator2);
		System.out.println(h5ListForFooter.size());//4
		for(WebElement e : h5ListForFooter) {
			if(e.getSize()!=null && e.isDisplayed()) {
				System.out.println(e.getText());
			}
		}
		/* o/p:
		 Information
         Customer Service
         Extras
		 My Account
		*/
		
		List<WebElement> allLinks = eleUtil.getChildElements(locator1, locator3);
		System.out.println(allLinks.size());//16
		for(WebElement e: allLinks) {
			System.out.println(e.getText());
		}
		
		//Assignment: right section links and text
		By locator4 = By.id("column-right");
		
		List<WebElement> rightSideLinks = eleUtil.getChildElements(locator4, locator3);
		System.out.println(rightSideLinks.size());//13
		for(WebElement e : rightSideLinks) {
			System.out.println(e.getText());
		}
	}

}

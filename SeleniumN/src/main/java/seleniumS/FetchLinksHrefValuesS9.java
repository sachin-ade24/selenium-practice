package seleniumS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchLinksHrefValuesS9 {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
	    List<WebElement> hrefLinks = driver.findElement(By.tagName("footer")).findElements(By.tagName("a"));
	    for(WebElement e : hrefLinks) {
	    	String hrefValue = e.getDomAttribute("href");
	    	System.out.println(hrefValue);
	    }
	    
	    System.out.println("=================================================");
		
	    driver.navigate().to("https://www.flipkart.com/");
	    
	    List<WebElement> imgList = driver.findElements(By.tagName("img"));
	    for(WebElement e : imgList) {
	    	String srcValue = e.getDomAttribute("src");
	    	System.out.println(srcValue);
	    }
	    
	}

}

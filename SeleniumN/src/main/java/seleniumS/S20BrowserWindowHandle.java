package seleniumS;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S20BrowserWindowHandle {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");//Parent window

		//Observe an attribute: target="_blank"
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("OrangeHRM"))).click().perform();
		//After above line we reached to a Child window --> https://www.orangehrm.com/en/company/about-us
		
		//1. Fetch the window ids:
		Set<String> windowHandlesSet = driver.getWindowHandles();
		//1. Set is non-order base collection i.e. it does not maintain the order
		//meaning, no specific or fixed index for your elements in the collection, like
		//normally ArrayList starts from 0th index. But for Set element,
		//the randomly the index will be assigned.
		//2. Set does not allow duplicate values, so only unique values are allowed
		
		//As we don't know which index points to which element/value of the Set, we need Iterator
		//iterator: Returns an iterator over the elements in this set. The elements are returned in no particular order 
		Iterator<String> iterate = windowHandlesSet.iterator();
		
		String parentWindowId = iterate.next();
		System.out.println("Parent window ID: " + parentWindowId);
		
		String childWindowId = iterate.next();
		System.out.println("Child window ID: " + childWindowId);
		
		driver.switchTo().window(childWindowId);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.close();//close current window
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
	}

}

package seleniumS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S21ImplicitWait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		/*
		- implicitlywait is global wait and it is applicable for all the 
		  upcoming elements (the elements which you are going to write after
		  this line)
		- It cannot be applied for a specific element. 
		  explicitly wait cannot be applied for a WebElement.
		- it cannot be applied for non WebElements: title, URL, alerts, window
		*/
		
	    //WebElement
		driver.findElement(By.id("input-firstname")).sendKeys("Sachin");
		
		//in real-time scenarios or real time projects we will never use
		//the implicit wait, because:
		
		//1. If you wan to change the implicit wait, you need to again
		//write the same line: i.e.
		//'driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));'
		//And from then onwards the 5 seconds wait will be applicable.
		
		//2. The another basic problem is, the implicit page is applicable for 
		//all elements on the web page, it doesn't matter whether the element
		//present on page or not.
		//The problem with this is every time when we want to
		//find the next element, we have to always go through the layer of the
		//implicit wait. It doesn't matter whether the element is present on
		//page or not. If element is available then it will not wait for that
		//but still program check whether we need to apply implicit wait or not.
		//So, performance wise it may degrade the performance.

	}

}

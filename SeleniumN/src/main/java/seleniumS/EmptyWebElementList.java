package seleniumS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmptyWebElementList {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		List<WebElement> allElements = driver.findElements(By.className("sachin"));
		
		//The 'sachin' class name is not present anywhere in the DOM
		//but still it will not throw 'NoSuchElementException'
		//because the 'findElements' method will either return 'List'
		//of the WebElements (if relevant element exists) or it will
		//return an empty List (if relevant element does not exist)
		System.out.println(allElements);//[]
		System.out.println(allElements.size());//0
		
		//But in case of 'findElement' method we will get
		//'NoSuchElementException'
	}

}

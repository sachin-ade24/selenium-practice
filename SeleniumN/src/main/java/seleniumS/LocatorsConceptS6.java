package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsConceptS6 {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		//1. id --> 1st priority
		driver.findElement(By.id("input-firstname")).sendKeys("Sachin");
		
		//2. name --> can be duplicate
		driver.findElement(By.name("lastname")).sendKeys("Ade");
		
		//3. className --> can be duplicate
		//driver.findElement(By.className("form-control")).sendKeys("s@b.com");
		//found 7 elements of same class name 
		//and it targets to the first element
		//but first element is not my desired element
		//so, I don't want to use the className
		
		//4. XPath:
		driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys("s@b.com");
		driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("9009977943");
		
		//5. CSS Selector
		driver.findElement(By.cssSelector("#input-password")).sendKeys("S@chin123");
		driver.findElement(By.cssSelector("#input-confirm")).sendKeys("S@chin123");
		
		//6. linkText: use only for the links: HTMLtag ==> <a>
		driver.findElement(By.linkText("Register")).click();
		
		//7. partialText: use only for the links: HTMLtag ==> <a>
		driver.findElement(By.partialLinkText("Forgotten")).click();
		
		//8. tagName: should be unique
		String forgotPwdHeaderText = driver.findElement(By.tagName("h1")).getText();
		System.out.println(forgotPwdHeaderText);
		

	}

}

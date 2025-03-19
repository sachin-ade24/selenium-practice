package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S19FileUploadPopUpHandle {

	static WebDriver driver;

	public static void main(String[] args) {
		
		//basic auth
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/upload");
		
		WebElement fileUploadEle = driver.findElement(By.xpath("//input[@type='file']"));
		
		Actions act = new Actions(driver);
		act.scrollToElement(fileUploadEle).perform();
		
		//type="file"
		fileUploadEle.sendKeys("C:/Users/suraj/git/selenium-practice/SeleniumN/src/main/java/setTimeout");

	}

}

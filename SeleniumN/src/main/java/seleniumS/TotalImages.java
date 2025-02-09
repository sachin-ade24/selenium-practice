package seleniumS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalImages {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		List <WebElement> allImg = driver.findElements(By.tagName("img"));
		
		System.out.println("Number of images available on page: " + allImg.size());

	}

}

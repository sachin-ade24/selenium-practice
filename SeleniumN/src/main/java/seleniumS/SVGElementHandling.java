package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElementHandling {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver =  new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(3000);
		
		//SVG: XPath
		// "//*[local-name()='svg']"
		
		driver.findElement(By.name("q")).sendKeys("mackbook");
		driver.findElement(By.xpath("//*[local-name()='svg']")).click();

	}

}

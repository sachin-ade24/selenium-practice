package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S18SVGElement {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://petdiseasealerts.org/forecast-map");

		driver.get("https://www.flipkart.com/");
		//SVG - Scalable Vector Graph
		//XPath
		// //*[local-name()='svg']
		
		driver.findElement(By.cssSelector("[placeholder='Search for Products, Brands and More']")).sendKeys("Samsung");
		driver.findElement(By.xpath("//*[local-name()='svg']")).click();
		
		
		
		
		
		
		
		
		
		
	}

}

package seleniumS;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForwardSimulation {

	public static void main(String[] args) throws MalformedURLException {
		
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://www.google.com");//valid
		driver.navigate().to("https://www.google.com");//valid
		System.out.println(driver.getTitle());
		
		//driver.navigate().to("https://www.amazon.com/");//valid
		driver.navigate().to(new URL("https://www.amazon.com/"));//valid
		//driver.get("https://www.amazon.com/");//valid
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().refresh();

	}

}

package seleniumS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGElementWithXpath {

	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver =  new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map/#/");
		Thread.sleep(3000);
		
		

	}

}

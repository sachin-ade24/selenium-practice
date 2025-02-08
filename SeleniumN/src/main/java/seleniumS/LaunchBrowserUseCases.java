package seleniumS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowserUseCases {

	public static void main(String[] args) {

		WebDriver driver =  new ChromeDriver();
		
		//driver = new ChromeDriver();//new chrome window will be opened
		//driver = new ChromeDriver();//new chrome window will be opened
		//driver = new ChromeDriver();//new chrome window will be opened
		
		driver.quit();
		//only last instance will be closed
		//not all browsers
		//reason: the 'driver' will be looking at last launched browser
		//i.e. the Object will point towards latest browser i.e. last one
		
		
	}

}

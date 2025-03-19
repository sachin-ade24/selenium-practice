package seleniumS;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S19AuthPopUpHandle {

	static WebDriver driver;

	public static void main(String[] args) {
		
		//basic auth
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		String username = "admin";
		String password = "admin";
		driver.get("https://" + username + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
	}

}

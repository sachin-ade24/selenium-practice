package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysConcept {

	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		WebElement firstName = driver.findElement(By.id("input-firstname"));
		WebElement lastName =  driver.findElement(By.id("input-lastname"));
		
		//1.
		String name  = "Sachin";
		//2.
		StringBuilder sb = new StringBuilder(" Suraj");
		//3.
		StringBuffer sf = new StringBuffer(" Prince");
		
		firstName.sendKeys(name, sb, sf, "Sachi");
		//lastName.sendKeys(null);//not allowed
		//IllegalArgumentException: 
		//Keys to send should not be a null CharSequence
		
		
		
		

	}

}

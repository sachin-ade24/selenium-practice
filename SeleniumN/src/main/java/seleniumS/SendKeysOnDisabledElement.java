package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysOnDisabledElement {

	static WebDriver driver;
	
	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");
		
		WebElement password_id = driver.findElement(By.id("pass"));
		//password_id.sendKeys("S123@bc");
		//ElementNotInteractableException
		//reason: element is disabled
		password_id.click();//nothing happened ==> no exception
		
		//System.out.println(password_id.getDomAttribute("disabled"));
		//true
		String disabledAttrValue = password_id.getDomAttribute("disabled");
		System.out.println(disabledAttrValue);//true
		

	}

}

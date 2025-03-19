package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S19ClassAttributeConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://app.hubspot.com/login/legacy");
		
		//email field class attribute contains combination of two classes
		//class="form-control private-form__control"
		
		//invalid
		//driver.findElement(By.className("form-control private-form__control"));
		
		//valid
		//WebElement emailEle = driver.findElement(By.xpath("(//input[contains(@class, 'private-form__control')])[1]"));
		//emailEle.sendKeys("abc@c.com");
		
		//invalid
		//driver.findElement(By.xpath("//input[@class='private-form__control']"));
		
		//valid
		driver.findElement(By.xpath("(//input[@class='form-control private-form__control'])[1]")).sendKeys("abc@c.com");
	}

}

package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S19IFrameHandling {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
		
		Actions action = new Actions(driver);
        action.pause(3000);
        
        WebElement imageContainer = driver.findElement(By.id("imageTemplateContainer"));
        action.moveToElement(imageContainer).click(imageContainer).build().perform();
        action.pause(3000);
        
        driver.switchTo().frame(driver.findElement(By.cssSelector("[id*='frame-one']")));
   
        driver.findElement(By.cssSelector("#q1 input")).sendKeys("Title");
        
        driver.switchTo().defaultContent();
        
        WebElement h3TextEle = driver.findElement(By.xpath("//h3[text()='Vehicle Registration Form']"));
        action.moveToElement(h3TextEle).perform();
        String text = h3TextEle.getText();
        System.out.println(text);
	}

}

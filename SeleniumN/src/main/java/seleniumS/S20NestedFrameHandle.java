package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S20NestedFrameHandle {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selectorshub.com/iframe-scenario/");
		
		//nested iframes: iframe1 contains iframe2 and iframe3; iframe2 contains iframe3.
		
		//Approach 1:
		
		//iframe1:
		driver.switchTo().frame("pact1");
		driver.findElement(By.cssSelector("input[title='Enter your first crush name']")).sendKeys("Don't know");
		
		//iframe2:
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'pact2')]")));
		driver.findElement(By.cssSelector("#jex")).sendKeys("Don't know");
		
		//iframe3:
		driver.switchTo().frame(driver.findElement(By.id("pact3")));
		driver.findElement(By.cssSelector("#glaf")).sendKeys("Kalpana");
		
		//f3 --> f2
		driver.switchTo().parentFrame();//valid
		String connectBtnText = driver.findElement(By.cssSelector("#connect")).getText();
		System.out.println(connectBtnText);
		
		//f2 --> f1
		driver.switchTo().parentFrame();
		String lostBtnText = driver.findElement(By.cssSelector("#lost")).getText();
		System.out.println(lostBtnText);
		
		//switch to main html dom
		driver.switchTo().defaultContent();//valid
		//driver.switchTo().parentFrame();//valid
		String text = driver.findElement(By.xpath("//h2[text()='Subscribe to our youtube channel']")).getText();
        System.out.println(text);
        
        //1. Forward direction:
        //1.1 Valid:
        //Main Page --> f1 : yes
        //f1--> f2 : yes
        //f2 --> f3 : yes
        
        //1.2. invalid:
        //Main Page --> f2 : no
        //Main Page --> f3 : no
        //f1 --> f3 : no
        
        //2. Reverse direction:
        //2.1 valid:
        //f3 --> f2 : yes
        //f2 --> f1 : yes
        //f1 --> Main Page : yes
        
        //2.2 invalid:
        //f3 --> f1 : no
        
        //Reverse and valid
        //f3 --> Main Page : yes --> default content
        //f2 --> Main Page : yes --> default content
        
        
        //Approach 2:
        
        driver.switchTo().frame("pact1")
        					.switchTo().frame("pact2")
        						.switchTo().frame("pact3")
        							.switchTo().parentFrame()
        								.switchTo().parentFrame()
        									.findElement(By.cssSelector("#inp_val"))
        										.sendKeys("..Selctors hub..");
	}

}

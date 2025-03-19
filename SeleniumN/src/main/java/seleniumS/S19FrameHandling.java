package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class S19FrameHandling {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");
		
		//Switch to frame using index
		//driver.switchTo().frame(2); //valid but not preferable
		
		//Switch to frame using name or id attribute values
		//driver.switchTo().frame("main");
		
		//Switch to frame using WebElement associated with the frame.
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[src='top.html']")));
		
		String h2Header = driver.findElement(By.tagName("h2")).getText();
		System.out.println(h2Header);
	}

}

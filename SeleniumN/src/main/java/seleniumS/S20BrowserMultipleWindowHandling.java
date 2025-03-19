package seleniumS;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S20BrowserMultipleWindowHandling {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial");//Parent window
		
		String parentWindowId = driver.getWindowHandle();
		
		Actions act = new Actions(driver);
		act.pause(3000);
		
		WebElement facebook = driver.findElement(By.cssSelector("[alt='facebook logo']"));
		WebElement linkedIn = driver.findElement(By.cssSelector("[alt='linkedin logo']"));
		WebElement youTube = driver.findElement(By.cssSelector("[alt='youtube logo']"));
		
		act.moveToElement(facebook).click(facebook).perform();
		act.moveToElement(linkedIn).click(linkedIn).perform();
		act.moveToElement(youTube).click(youTube).perform();
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> iterate = handles.iterator();
		
		//hasNext(): Returns true if the iteration has more elements.
		while(iterate.hasNext()) {
			String windowId = iterate.next();
			driver.switchTo().window(windowId);
			System.out.println("Current URL: " + driver.getCurrentUrl());
			if(!windowId.equals(parentWindowId)) {
				driver.close();
			}
			act.pause(1500);
		}
		
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window URL: " + driver.getCurrentUrl());
	}

}

package seleniumS;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S18SVGElementWithXpath {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://petdiseasealerts.org/forecast-map");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement iFrameEle = driver.findElement(By.xpath("//iframe[contains(@id, 'map-instance')]"));
		driver.switchTo().frame(iFrameEle);
		
		By stateElement = By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @class='region']");
		By regions = By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']");
		List<WebElement> allStates = driver.findElements(stateElement);
		System.out.println(allStates.size());
		WebElement regionsElement = driver.findElement(regions);
		Actions action = new Actions(driver);
		action.moveToElement(regionsElement).perform();
		for(WebElement state: allStates) {
			action.moveToElement(state).perform();
			System.out.println(state.getDomAttribute("id"));
		}
		

	}

}

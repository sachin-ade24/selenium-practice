package seleniumS;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S15ActionsDragAndDrop {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		By drag = By.id("draggable");
		By drop = By.id("droppable");
		WebElement draggableEle = driver.findElement(drag);
		WebElement droppableEle = driver.findElement(drop);
		
		Actions action = new Actions(driver);
		
		//Approach 1:
		//action.clickAndHold(draggableEle).moveToElement(droppableEle).release().build().perform();
	
	    //Approach 2:
		action.dragAndDrop(draggableEle, droppableEle).build().perform();
	}

}

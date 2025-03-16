package seleniumS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S15ActionsRightClick {

	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		//Right click --> Context click
		By rightClickBtn = By.xpath("//span[text()='right click me']");
		WebElement rightClickBtnEle = driver.findElement(rightClickBtn);
		
		Actions action = new Actions(driver);
        action.contextClick(rightClickBtnEle).build().perform();
        
        By menuIcon = By.cssSelector(".context-menu-icon");
        List<WebElement> icons = driver.findElements(menuIcon);
        System.out.println(icons.size());
        
        for(WebElement icon: icons) {
        	WebElement iconTagNameEle = icon.findElement(By.tagName("span"));
        	System.out.println(iconTagNameEle.getText());
        	if(iconTagNameEle.getText().equals("Copy")) {
        		iconTagNameEle.click();
        		break;
        	}
        }
        
	}

}

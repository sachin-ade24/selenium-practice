package seleniumS;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S16JavaScriptAlertPopUpsHandling {


	static WebDriver driver;

	public static void main(String[] args) {
		
		//alert JS pop up:
		//alert: with normal text --> only with 'OK' button
		//confirm: with normal text --> with 'OK' and 'cancel' buttons
		//prompt: with normal text --> with a text box, 'OK' and 'cancel' buttons
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//1. JS Alert
		WebElement jsAlertEle = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		jsAlertEle.click();
		
		Alert alert = driver.switchTo().alert();
		System.out.println("JS Alert: " + alert.getText());
		alert.accept();
		
		WebElement resultEle = driver.findElement(By.cssSelector("#result"));
		String resultForAlertText = resultEle.getText();
		System.out.println("Result for JS Alert: " + resultForAlertText);
		
		
		//2. JS Confirm
		WebElement jsConfirmEle = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		jsConfirmEle.click();
		
		Alert confirm = driver.switchTo().alert();
		System.out.println("JS Confirm: " + confirm.getText());
		confirm.accept();
		
		String resultForConfirmText = resultEle.getText();
		System.out.println("Result for JS Confirm: " + resultForConfirmText);
		
		
		//3. JS Prompt
		WebElement jsPromptEle = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		jsPromptEle.click();
		
		Alert prompt = driver.switchTo().alert();
		System.out.println("JS Prompt: " + prompt.getText());
		prompt.sendKeys("JS Prompt");
		prompt.accept();
		
		String resultForPromptText = resultEle.getText();
		System.out.println("Result for JS Prompt: " + resultForPromptText);
	}

}

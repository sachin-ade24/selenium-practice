package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		//driver.navigate().to("");
		
		//step1: type cast
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//step2: pass JavaScript command in the argument of 'executeScript'
		//String title = js.executeScript("return document.title;").toString();
		//System.out.println(title);
		
		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		//jsUtil.generateAlertUsingJsExecutor("Hi Sachin...");
		
		//String textOnThePage = jsUtil.getWholeTextOfThePageUsingJsExecutor();
		//System.out.println(textOnThePage);
		WebElement ele = driver.findElement(By.xpath("//footer//p//a[text()='OpenCart']"));
		jsUtil.scrollIntoViewUsingJsExecutor(ele);
		jsUtil.scrollToTopUsingJsExecutor();
		jsUtil.scrollDownUsingJsExecutor("1000");
		jsUtil.drawBorderUsingJsExecutor(ele);
		WebElement e = driver.findElement(By.xpath("//a[text()='Register']"));
		jsUtil.clickOnTheElementUsingJsExecutor(e);
	}

}

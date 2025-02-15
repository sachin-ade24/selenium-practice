package seleniumS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	
	private WebDriver driver;
	private JavascriptExecutor js;
	
	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor)driver;
	}
	
	public String getTitleUsingJsExecutor() {
		return js.executeScript("return document.title;").toString();
	}
	
	public String getCurrentUrlUsingJsExecutor() {
		return js.executeScript("return document.URL;").toString();
	}
	
	public void refreshThePageUsingJsExecutor() {
		js.executeScript("return history.go(0);");
	}
	
	public void navigateBackUsingJsExecutor() {
		js.executeScript("return history.go(-1);");
	}
	
	public void navigateForwardUsingJsExecutor() {
		js.executeScript("return history.go(1);");
	}
	
	public void generateAlertUsingJsExecutor(String message) {
		js.executeScript("alert('" + message + "');");
	}
	
	public String getWholeTextOfThePageUsingJsExecutor() {
		return js.executeScript("return document.documentElement.innerText;").toString();
	}
	
	public void scrollToBottomUsingJsExecutor() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}
	
	public void scrollToTopUsingJsExecutor() {
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0);");
	}
	
	public void scrollDownUsingJsExecutor(String height) {
		js.executeScript("window.scrollTo(0, '" + height + "');");
	}
	
	public void scrollIntoViewUsingJsExecutor(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void drawBorderUsingJsExecutor(WebElement element) {
		js.executeScript("arguments[0].style.border='3px solid red';", element);
	}
	
	public void clickOnTheElementUsingJsExecutor(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	
	public void sendKeysUsingJsExecutorWithId(String idValue, String msgOrTxt) {
		js.executeScript("document.getElementById('"+ idValue +"').value='"+msgOrTxt+"'");
	}
}

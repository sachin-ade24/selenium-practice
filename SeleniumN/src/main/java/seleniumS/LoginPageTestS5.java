package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageTestS5 {

	public static void main(String[] args) {
		
		BrowserUtilS4 brUtil = new BrowserUtilS4();
		WebDriver driver = brUtil.initDriver("chrome");
		brUtil.launchTheUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		brUtil.getPageTitle();
		brUtil.getPageUrl();
		
		By email = By.id("input-email");
		By password = By.id("input-password");
		
		ElementUtilS5 eleUtil = new ElementUtilS5(driver);
		eleUtil.type(email, "sachin123@amail.com");
		eleUtil.type(password, "S@chin123");

	}

}

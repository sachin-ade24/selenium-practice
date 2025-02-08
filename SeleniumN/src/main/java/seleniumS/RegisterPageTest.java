package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterPageTest {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		By firstName = By.id("input-firstname");
		By lastName = By.name("lastname");
		By search = By.className("form-control");
		By email = By.xpath("//*[@id=\"input-email\"]");
		By telephone = By.cssSelector("#input-telephone");
		By password = By.xpath("//*[@id=\"input-password\"]");
		By passwordConfirm = By.cssSelector("#input-confirm");
		By policyCheck = By.name("agree");
		By continueBtn = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");
		By successMsg = By.tagName("h1");
		By myAccountLink = By.linkText("My Account");
		
		ElementUtilS5 eleUtil = new ElementUtilS5(driver);
		eleUtil.type(firstName, "Sachin");
		eleUtil.type(lastName, "Ade");
		eleUtil.type(search, "mac book");
		eleUtil.type(email, "s@b.com");
		eleUtil.type(telephone, "1234567890");
		eleUtil.type(password, "S@123");
		eleUtil.type(passwordConfirm, "S@123");
		eleUtil.clickOnTheElement(policyCheck);
		eleUtil.clickOnTheElement(continueBtn);
		
		String successMsgText = eleUtil.getElementText(successMsg);
		System.out.println(successMsgText);
		if(successMsgText.contains("Your Account Has Been Created!")) {
			System.out.println("User is created -- Test PASSED");
		}else {
			System.out.println("User registration FAILED");
		}
		
		eleUtil.clickOnTheElement(myAccountLink);


	}

}

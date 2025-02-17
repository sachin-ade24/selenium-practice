package mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class OpenCartTest extends BaseTest{
	
	@Test
	public void titleTest() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Account Login");
	}
	
	@Test
	public void forgottenPasswordIsDisplayed() {
		WebElement forgottenPassword = driver.findElement(By.cssSelector(".well")).findElement(By.xpath("//a[text()='Forgotten Password']"));
		
		String actualText = forgottenPassword.getText();
		Assert.assertEquals(actualText, "Forgotten Password");
		Assert.assertTrue(forgottenPassword.isDisplayed());
	}
	
	
	
	
	
}

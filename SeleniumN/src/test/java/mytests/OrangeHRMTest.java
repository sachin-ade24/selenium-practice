package mytests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class OrangeHRMTest extends BaseTest{
	
	@Test
	public void titleTest() {
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "30-Day Advanced Free Trial | OrangeHRM");
	}
	
	@Test
	public void whyOrangeHRMIsDisplayed() {
		WebElement whyOrangeHRM = driver.findElement(By.cssSelector("#navbarSupportedContent")).findElement(By.xpath("//a[text()='Why OrangeHRM']"));
		
		//String actualText = whyOrangeHRM.getText();
		//Assert.assertEquals(actualText, "Forgotten Password");
		Assert.assertTrue(whyOrangeHRM.isDisplayed());
	}
	
}

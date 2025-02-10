package seleniumS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXPath {

	public static void main(String[] args) {
		
		//XPath is not an attribute/property
		//It is the address of the element in the HTML DOM
		
		//1. Absolute XPath: it is not stable, so never use
		//rightClick -> inspect -> click on an element -> rightClick
		//-> click on copy -> click on 'Copy full XPath' 
		
		//2. Relative XPath: custom XPath: functions, text, axes
		//Always use relative or custom XPath
		//2.1:
		//rightClick -> inspect -> click on an element -> rightClick
		//-> click on copy -> click on 'Copy XPath' 
	    //2.2:
		//create your own custom XPath
		
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		//How to write XPath:
		//Common Format: "//tagName[@attrName='valueOfTheAttr']" 
		//By emaiIdXpath = By.xpath("//input[@id='input-email']");
		//WebElement email = driver.findElement(emaiIdXpath);
		//email.sendKeys("test@123.com");
		
		//with two attributes:
		//Format: "//tagName[@attrName1='valueOfTheAttr' and @attrName2='valueOfTheAttr']" 
		//By twoAttr = By.xpath("//input[@type='submit' and @value='Login']");
		//By threeAttr = By.xpath("//input[@type='password' and @name='password' and @placeholder='Password']");
		
		//
		//XPaths:
		//Formats: 
		//1: "//input" --> 6 elements available
		//2: "//a" --> 81 elements available
		//3: "//a[@href]" --> 81 elements available
		//4: "//img" --> 1 element available
		//5: "//button" --> 7 elements available
		//6: "//input[@type='text']" --> 2
		//7: "//input[@id]" --> 2
		//7: "//input[@id and @type]" --> 2
		
		//8: text():
		//Format: "htmlTag[text()='textValue']"
		//8.1: "//a[text()='Forgotten Password']" --> 2
		
		//
		//text() and attribute
		//htmlTag[text()='value' and attrName='value']
		//e.g.: "//a[text()='Register' and @class='list-group-item']"
		//htmlTag[text()='value' and attrName='value' and attrName='value']
		//a[text()='Address Book' and @class='list-group-item']
		//a[@class='list-group-item' and text()='Address Book' ]
		
		//contains():
		//Format: //tagName[contains(@attr, attrValue)]"
		//e.g.: 
		//1: "//input[contains(@id, 'input-email')]"
		//2: "//a[contains(@href, 'login') and contains(text(), 'Login') and contains(@class, 'list-group-item')]"
		//3: "//input[contains(@placeholder, Address) and contains(@id, 'input-email')]"

		//4: paragraph:
		// "//p[contains(text(), 'By creating an account')]"
		// "//p[contains(text(), 'By creating an account') and contains(text(), 'keep track')]"
		
		//XPath: "//p[contains(text(), "order's status")]"
		String text = driver.findElement(By.xpath("//p[contains(text(), \"order's status\")]")).getText();
		System.out.println(text);
		//By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.
		
		// "//a[contains(text(), 'Recurring payments') and contains(@href, 'route=account/recurring')]"
		// "//a[contains(@href, 'route=account/recurring') and contains(text(), 'Recurring payments')]"
		
		//Dynamic element:
		//<input> id="firstname_123"
		//<input> id="middlename_456"
		//<input> id="lastname_789"
		//XPath: "//input[contains(@id, 'firstname_')]"
		
		//starts-with();
		//Format: "//htmlTag[starts-with(text(), 'value')]" 
		//e.g.: "//p[starts-with(text(), 'By creating an account')]"
		
		//ends-with() --> not available
		
		//
		//indexing
		//Format: 
		//1: "(//tagName[@attrName='valueOfTheAttr'])[indexNumber]"
		//2: "(//tagName)[indexNumber]"
		//3: "(//tagName[@attrName])[indexNumber]"
		//4: "(//tagName[contains(text(), 'value')])[indexNumber]"
		
		//position function: position()
		//5: "(//tagName)[position()=indexNumber]" e.g. "(//a)[position()=2]"
		
		//last function: last()
		//6: 
		//6.1: "(//tagName)[last()]"
		//6.2: "(//tagName)[last()-1]"
		//6.3: "(//tagName)[last()-2]"
		
		//Amazon footer 'Help' XPath: all following XPaths are for 'Help'
		// "((//div[contains(@class, 'navFooterLinkCol')])[last()]//li)[7]"
		// "(//div[contains(@class, 'navFooterLinkCol')])[last()]//a[text()='Help']"
		// "((//div[contains(@class, 'navFooterLinkCol')])[last()]//li)[last()]"
		// "((//div[contains(@class, 'navFooterLinkCol')])[last()]/ul//li)[last()]"
		// "((//div[contains(@class, 'navFooterLinkCol')])[last()]/ul/li)[last()]"
		// "((//div[contains(@class, 'navFooterLinkCol')])[last()]/ul/li/a)[last()]"
		// "((//div[contains(@class, 'navFooterLinkCol')])[last()]/ul/li//a)[last()]"
		
		
	}

}

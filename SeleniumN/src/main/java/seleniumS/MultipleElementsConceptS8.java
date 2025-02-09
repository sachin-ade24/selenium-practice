package seleniumS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleElementsConceptS8 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		List<WebElement> allLinksOnCurrentPage= driver.findElements(By.tagName("a"));
		System.out.println("Number of links present on current page: " + allLinksOnCurrentPage.size());
		
		//valid:
		for(int i=0; i<allLinksOnCurrentPage.size(); i++) {
			//System.out.println(allLinksOnCurrentPage.get(i).getDomAttribute("href"));
			String linkText = allLinksOnCurrentPage.get(i).getText();
			if(linkText.length()!=0) {
				System.out.println(linkText);
			}
		}
		
		System.out.println("=========================================================");
		
		//valid:
		for(WebElement e: allLinksOnCurrentPage) {
			if(!e.getText().isBlank()) {
				System.out.println(e.getText());
			}
		}


	}

}

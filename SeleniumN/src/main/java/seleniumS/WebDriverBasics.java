package seleniumS;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		//if you write like: driver.get("https://google.com");
		//it works for above line
		String title = driver.getTitle();
		System.out.println(title);
		if(title.equals("Google")) {
			System.out.println("Passed");
		} else {
			System.err.println("Failed");
		}
		driver.quit();
	}

}

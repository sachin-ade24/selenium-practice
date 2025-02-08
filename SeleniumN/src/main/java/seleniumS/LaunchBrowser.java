package seleniumS;

public class LaunchBrowser {

	public static void main(String[] args) {
		
		//Selenium2:*************************************************
		//Selenium team was developing all driver '.exe' files (for windows)
		//or driver files --> here driver file is server file
		//your code will given to server first and then server will
		//interact with browser
		//all the browser driver.exe means:
		//chromedriver.exe, geckodriver.exe, edgedriver.exe, safaridriver.exe
		//etc.
		//problem:
		//when Selenium devs creating driver.exe for all browsers
		//that time for each new browser version release, 
		//the selenium dev team need to create a new driver each time
		
		//Selenium3:*************************************************
		//all above driver.exe were provided by vendors
		//meaning --> 
		//cromedriver --> chromium team (google)
		//geckodriver --> firefox team
		//edgedriver --> microsoft team
		//but still one major problem was there:
		//problem: each time all browser vendors are providing the 
		//executable server files but every time we have to go on there
		//relevant url and download it and store it in our local machine
		//and the by using 'System.setProperty(key, value)' we need to
		//give the key for example: 'webdriver.chrome.driver'
		//value: 'path from your local machine where you kept the .exe file'
	
		//Selenium4:*************************************************
		//this time they resolved above major issue
		//this time we need to just write the line
		//WebDriver driver = new ChromeDriver();
		//and it will automatically check whether we have the .exe file
		//for the relevant browser here let's say chrome browser
		//then it will start interacting with the actual browser directly
		//and in case we don't have the .exe file then,
		//it will download it for us and start using it, i.e. it starts
		//interacting with the browser
		
		//from 4.6.0 it is happening..
		//they are using seleniumManager for this
		
		//where it downloads the .exe:user --> .cache --> .exe
		
		//============================================
		
		/* Architecture summary:
		 * language binding --> server i.e. .exe --> actual browser
		 * e.g.:
		 * Selenium Java --> ChromeDriver --> Google Chrome
		 * */
		
		
	}

}

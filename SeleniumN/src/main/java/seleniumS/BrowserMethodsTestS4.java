package seleniumS;

public class BrowserMethodsTestS4 {

	public static void main(String[] args) {

		BrowserUtilS4 br = new BrowserUtilS4();
		
		br.initDriver("chrome");
		br.launchTheUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		br.getPageUrl();
		br.getPageTitle();
		br.quitTheBrowser();

	}

}

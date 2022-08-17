package seleniumsession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {
	
	private WebDriver driver;
	
	/**
	 * This method is used to initialize the driver on the basis of given browser
	 * name
	 * 
	 * @param browserName
	 * @return this returns driver
	 */
	
	public WebDriver initDriver(String browserName) {		
		System.out.println("Browser Name is: "+ browserName);		
		if(browserName.equalsIgnoreCase("chrome")) {			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();			
		}else if (browserName.equalsIgnoreCase("firefox")){			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}else if (browserName.equalsIgnoreCase("edge")) {			
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			System.out.println("Please pass the right browser..."+ browserName);
		}		
		return driver;
	}
	
	public void launchUrl(String url) {		
		if(url == null) {
			System.out.println("url entered is null");
			return;
		}
		if(url.indexOf("http")== -1) {
			System.out.println("url is not having http");
			return;
		}
		if(url.indexOf("https")== -1) {	
			System.out.println("url is not having https");
			return;
		}
		driver.get(url);	
	}
	
	/**
	 * this method is used to return the page title
	 * 
	 * @return
	 */
	
	public String getPageTitle() {
		
		String title = driver.getTitle();
		System.out.println("Title of the Page is :"+ title);
		return title;
	}
	
	public String getPageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println("Page URL is :"+ url);
		return url;
	}
	
//	public boolean isUrlFractionExist(String urlFraction) {
//		boolean bl = getPageUrl().contains(urlFraction);
//		return bl;
//	}
	
	public boolean isUrlFractionExist(String urlFraction) {
		if (getPageUrl().contains(urlFraction)) {
			return true;
		}
		return false;
	}
	
	public String getPageSource() {
		String source = driver.getPageSource();
//		System.out.println("Page Source is : "+source);
		return source;
	}
	
	public boolean isInfoExistInPageSource(String src) {
		if(getPageSource().contains(src)) {
			return true;
		}
		return false;
	}

	public void closeBrowser() {
		driver.close();
	}
	
	public void quitBrowser() {
		driver.quit();
	}
	
}

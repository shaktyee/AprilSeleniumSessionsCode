package seleniumsession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {

//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\000KRA744\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//WebDriver driver = WebDriverManager.chromedriver().create();
				
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();// launch chrome

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");// enter url

		String title = driver.getTitle();// get the title
		System.out.println("page title is: " + title);
		if(title.equals("Account Login")) {
			System.out.println("Page Title is Correct");
		}else {
			System.out.println("Page Title is Incorrect");
		}
		
		String url = driver.getCurrentUrl();
		System.out.println("URL Launched is: "+ url);
		if(url.contains("account/login")) {
			System.out.println("Correct URL is Launched");
		}else {
			System.out.println("Incorrect URL Launched");
		}
		
		
		driver.quit();
		
	}

}

package mytests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
WebDriver driver;
	
	@BeforeTest
	@Parameters({"url","browser"})
	public void setup(String url, String browserName) {
		
		System.out.println("Browser launched is: "+ browserName);		
		if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			System.out.println("Incorrect browser entered");
		}
		driver.get(url);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

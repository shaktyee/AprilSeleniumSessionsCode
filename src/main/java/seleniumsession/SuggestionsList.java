package seleniumsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuggestionsList {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		
//		driver.findElement(By.id("search_query_top")).sendKeys("Dress");
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//li[text()='T-shirts > Faded Short Sleeve T-shirts']")).click();
		
		By search = By.id("search_query_top");
//		By productName = By.xpath("//li[text()='T-shirts > Faded Short Sleeve T-shirts']");
		
		doSendKeys(search,"Dress");
		Thread.sleep(5000);
		selectItem("T-shirts > Faded Short Sleeve T-shirts");
//		driver.quit();
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator, String item) {
		getElement(locator).sendKeys(item);
	}
	
	public static void selectItem(String productName){
		driver.findElement(By.xpath("//li[text()='"+productName+"']")).click();				
	}

}

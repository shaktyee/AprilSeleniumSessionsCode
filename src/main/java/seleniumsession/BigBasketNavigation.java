package seleniumsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BigBasketNavigation {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com/");
		
		Thread.sleep(5000);
		
		selectLevel4Product("Beverages","Tea","Green Tea","Tata Tea");
	}
	
	public static void selectLevel4Product(String l1, String l2, String l3, String l4) throws InterruptedException {
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@class = 'dropdown-toggle meganav-shop']"))).perform();
		Thread.sleep(2000);
		
		act.moveToElement(driver.findElement(By.linkText(l1))).perform();
		Thread.sleep(2000);
		
		act.moveToElement(driver.findElement(By.linkText(l2))).perform();
		Thread.sleep(2000);
		
		act.moveToElement(driver.findElement(By.linkText(l3))).perform();
		Thread.sleep(2000);
		
		act.moveToElement(driver.findElement(By.linkText(l4))).click().build().perform();
		Thread.sleep(2000);
	}

}

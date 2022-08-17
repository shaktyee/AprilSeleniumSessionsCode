package seleniumsession;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForTitle {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.linkText("Books")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		if(wait.until(ExpectedConditions.titleContains("Store"))) {
//			System.out.println("PASS");
//		}
		String title = waitForTitleContains(10,"Store");
		System.out.println(title);
		
		String title1 = waitForTitleToBe(10,"Book Store Online : Buy Books Online at Best Prices in India | Books Shopping @ Amazon.in");
		System.out.println(title1);
		
		
	}
	public static String waitForTitleContains(int timeout,String titleFractionValue) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.titleContains(titleFractionValue))) {
			System.out.println("PASS");
			return driver.getTitle();
		}else {
			System.out.println("title not found");
			return null;
		}
		
	}
	public static String waitForTitleToBe(int timeout,String titleValue) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		if(wait.until(ExpectedConditions.titleIs(titleValue))) {
			System.out.println("PASS");
			return driver.getTitle();
		}else {
		System.out.println("title not found");
		return null;
	}
}
	
}

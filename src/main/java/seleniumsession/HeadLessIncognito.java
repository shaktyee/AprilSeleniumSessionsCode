package seleniumsession;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessIncognito {

	public static void main(String[] args) {

//		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
//		ChromeOptions co = new ChromeOptions();
//		co.addArguments("--headless");
//		co.setHeadless(true);
//		co.addArguments("--incognito");
		FirefoxOptions fo = new FirefoxOptions();
		fo.addArguments("--headless");
		
		WebDriver driver = new FirefoxDriver();
//		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.google.co.in/");
		
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		
		driver.quit();
	}

}

package seleniumsession;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		By textbox = By.id("twotabsearchtextbox");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofSeconds(2))
			.ignoring(NoSuchElementException.class,StaleElementReferenceException.class)
			.withMessage("element is not present on the page.....Sorry.....");
		
		//WebDriverWait(C) --> FW(C) --> wait(I)
		
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//				.withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2))
//				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class)
//				.withMessage("element is not present on the page.....Sorry.....");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(textbox)).sendKeys("shakti");
		
	}

}

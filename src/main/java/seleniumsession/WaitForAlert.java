package seleniumsession;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForAlert {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.name("proceed")).click();
		
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
//		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		
//		System.out.println(alert.getText());
//		alert.accept();
		
		System.out.println(getAlertText(10));
		aceptAlert(10);
		
	}
	
	public static Alert waitForAlert(int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public static String getAlertText(int timeout) {
		return waitForAlert(timeout).getText();
	}
	public static void aceptAlert(int timeout) {
		waitForAlert(timeout).accept();
	}
	
	public static void dismissAlert(int timeout) {
		waitForAlert(timeout).dismiss();
	}
	
	public void alertSendKeys(int timeout, String value) {
		waitForAlert(timeout).sendKeys(value);
	}

}

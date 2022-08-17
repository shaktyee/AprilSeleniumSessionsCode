package seleniumsession;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitConcept {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		// 2.b: Explicit Wait: dynamic wait
		// 2.b.1: WebDriverWait
		// 2.b.2: FluentWait

		// for a specific web element only, not a global wait
		// can be applied for non web elements: alerts, url, title

		// WebDriverWait(class) --> extends --> FluentWait(class) --> implements -->
		// Wait(I) -> until(); method
		// no methods //unit(){}
		// other methods (){}

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		By emailid = By.id("input-email");
		By pwd = By.id("input-password");
		By loginbtn = By.xpath("//input[@value='Login']");
		
		//presenceOfElementLocated:
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement email_ele = wait.until(ExpectedConditions.presenceOfElementLocated(emailid));
//		email_ele.sendKeys("shakti@gmail.com");
		
//		doSendKeysWithWait(5,emailid,"shakti@gmail.com");
//		doSendKeys(pwd,"test@123");
//		doClick(loginbtn);	
		
		//visibility of the element: 
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement email_ele = wait.until(ExpectedConditions.visibilityOfElementLocated(emailid));
		email_ele.sendKeys("shakti@gmail.com");
		
	}
	
	/**
	 *  An expectation for checking that an element is present on the DOM of a page. 
	 *  This does not necessarily mean that the element is visible.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	
	public static WebElement waitForElementPresence(int timeOut, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public static void doSendKeysWithWait(int timeOut, By locator,String value) {
		waitForElementPresence(timeOut,locator).sendKeys(value);
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator,String value) {
		getElement(locator).sendKeys(value);
	}
	
	public static void doClick(By locator) {
		getElement(locator).click();
	}
	
	public static void doClickWithWait(int timeOut,By locator) {
		waitForElementPresence(timeOut,locator).click();
	}
	
	/**
	 * An expectation for checking that an element is present on the DOM of a page and visible. 
	 * Visibility means that the element is not only displayed 
	 * but also has a height and width that is greater than 0.
	 * @param locator
	 * @param timeOut
	 * @return
	 */
	
	public static WebElement waitForElementVisible(int timeOut,By locator) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

}

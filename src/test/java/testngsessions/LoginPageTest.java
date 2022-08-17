package testngsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
	}
	
	@Test(priority = 1)
	public void logoTest() {
		boolean flag = driver.findElement(By.xpath("//img[@title=\"naveenopencart\"]")).isDisplayed();
		Assert.assertEquals(flag, true);
	}
	
	@Test(priority=3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(driver.findElement(By.linkText("Forgotten Password")).isDisplayed());
	}
	
	@Test(priority=2)
	public void loginNegativeTest() {
		driver.findElement(By.id("input-email")).sendKeys("shakti@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("test@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().trim();
		Assert.assertEquals(errorMessage, "Warning: No match for E-Mail Address and/or Password.");
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

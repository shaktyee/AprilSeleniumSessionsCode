package seleniumsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IframeHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");	//page
		
		driver.findElement(By.xpath("//div[@id = 'imageTemplateContainer']/img")).click();
		
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'frame-one')]")));
		
		driver.findElement(By.id("RESULT_TextField-7")).sendKeys("1234567");
		
		driver.switchTo().defaultContent();
		
	}

}

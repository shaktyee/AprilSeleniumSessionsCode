package seleniumsession;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForElements {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.amazon.com/");
		
		By footer = By.xpath("//div[@class='navFooterVerticalRow navAccessibility']//ul/li/a");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		List<WebElement> footerList =
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(footer));
		
		System.out.println(footerList.size());
		for(WebElement e:footerList) {
			String text = e.getText();
			System.out.println(text);
		}
	}

}

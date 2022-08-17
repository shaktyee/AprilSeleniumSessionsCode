package seleniumsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonFooterText {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
//		String columnHeader = driver
//			.findElement(By.xpath("//a[text()='About Us']/ancestor::div[@class='navFooterLinkCol navAccessibility']/div"))
//			.getText();
//		System.out.println(columnHeader);
		
		System.out.println(getHeaderValue("Careers"));
		System.out.println(getHeaderValue("Advertise Your Products"));
		System.out.println(getHeaderValue("Facebook"));
		System.out.println(getHeaderValue("Help"));
		
		driver.quit();
		
	}
	
	public static String getHeaderValue(String footerLinkText) {
		return driver.findElement(By.xpath("//a[text()='"+footerLinkText+"']/ancestor::div[@class='navFooterLinkCol navAccessibility']/div")).getText();
	}

}

package seleniumsession;

import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandleOneByOne {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		
		//1.
		
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String pw = it.next();
		String cw = it.next();
		
		driver.switchTo().window(cw);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(pw);
		
		
		//2.
		
		driver.findElement(By.cssSelector("img[alt='OrangeHRM on Facebook']")).click();
		Thread.sleep(2000);
		Set<String> handles2 = driver.getWindowHandles();
		Iterator<String> it2 = handles2.iterator();
		pw = it2.next();
		cw = it2.next();
		
		driver.switchTo().window(cw);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(pw);
		driver.quit();
		
		
		
	}

}

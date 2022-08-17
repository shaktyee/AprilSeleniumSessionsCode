package seleniumsession;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWindowHandle {
	
	static WebDriver driver;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String pw = it.next();
		System.out.println("Parent Window ID is:"+ pw);
		
		String cw = it.next();
		System.out.println("Child window id is:"+cw);
		
		driver.switchTo().window(cw);
		System.out.println("Child window url is:"+driver.getCurrentUrl());
		System.out.println("Child window title is:"+driver.getTitle());
		driver.close();
		
		driver.switchTo().window(pw);
		System.out.println("Parent window url is:"+driver.getCurrentUrl());
		System.out.println("Parent window title is:"+driver.getTitle());
		driver.quit();
		
		
	}

}

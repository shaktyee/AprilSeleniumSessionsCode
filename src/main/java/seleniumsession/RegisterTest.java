package seleniumsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterTest {

	public static void main(String[] args) {

		BrowserUtil bu = new BrowserUtil();
		WebDriver driver = bu.initDriver("chrome");
		bu.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		System.out.println(bu.getPageTitle());
		System.out.println(bu.getPageUrl());
		
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By email = By.id("input-email");
		By telep = By.id("input-telephone");
		By pwd = By.id("input-password");
		By pwdcon = By.id("input-confirm");
		
		ElementUtil eu = new ElementUtil(driver);
		eu.doSendKeys(fname, "shakti");
		eu.doSendKeys(lname, "samal");
		eu.doSendKeys(email, "shakti.samal@gmail.com");
		eu.doSendKeys(telep, "1234567890");
		eu.doSendKeys(pwd, "test@123");
		eu.doSendKeys(pwdcon, "test@123");
		
		
	}

}

package com.fashion.testcases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fashion.pageobject.LogincicdPage;
import com.fashion.pageobject.NewsFeedPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.fashion.utilities.ExtentListenerClass.class)
public class Logoutcicd {
	WebDriver driver = new ChromeDriver();
	public LogincicdPage loginPg;
	public NewsFeedPage newsfeedPg;
	public static Logger logger = LogManager.getLogger(Logoutcicd.class);

	@BeforeMethod
	public void startChrome() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		loginPg = new LogincicdPage(driver);
		newsfeedPg = new NewsFeedPage(driver);
		driver.get(Routescicd.linkcicd);
		logger = LogManager.getLogger("Seleniumcicd");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	}

	// Testcase to Verify the login user with valid credentials
	@Test(priority = 1, enabled = true)
	public void loginFunctionality() throws InterruptedException {
		Thread.sleep(300);
		loginPg.enterUserName(Routescicd.usernamecicd);
		logger.info("enter user name");
		loginPg.enterPassword(Routescicd.passwordcicd);
		logger.info("enter password");
		WebElement uplaodbtn = loginPg.login_btn();
		uplaodbtn.click();
		Thread.sleep(800);
		logger.info("click login");

	}
	
	@Test(priority = 2, enabled=true) 
	  public void logoutTest() throws InterruptedException {
	  
	  WebElement logout_svg = driver.findElement(By.xpath("//*[name()='svg'and @class ='w-4 h-4 transition-transform duration-300 ']"));
		Actions act = new Actions(driver);
		act.moveToElement(logout_svg).click().build().perform();
		Thread.sleep(2000);
		WebElement logout_btn = driver.findElement(By.xpath("//button[text()='Logout']"));
		if (logout_btn.isDisplayed() && logout_btn.isEnabled()) {
			logout_btn.click();
			System.out.println("User logged out successfully");
		} else {
			System.out.println("Not LoggedOut");
		}
	}
	
	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

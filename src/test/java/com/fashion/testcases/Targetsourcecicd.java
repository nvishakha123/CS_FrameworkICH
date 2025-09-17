package com.fashion.testcases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fashion.pageobject.LogincicdPage;
import com.fashion.pageobject.TargetPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Targetsourcecicd{
	
	WebDriver driver = new ChromeDriver();
	public LogincicdPage loginPg;
	public TargetPage targetPg;
	public static Logger logger = LogManager.getLogger(Targetsourcecicd.class);

	@BeforeMethod
	public void startChrome() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		loginPg = new LogincicdPage(driver);
		targetPg = new TargetPage(driver);
		driver.get("https://ichnextlabs.ai/auth/login");
		logger = LogManager.getLogger("Seleniumcicd");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	}

	// Testcase to Verify the login user with valid credentials
	@Test(priority = 1, enabled = true)
	public void loginFunctioanlity() throws InterruptedException {
		Thread.sleep(300);
		loginPg.enterUserName("vishakha.nandanwar@kreedalabs.com");
		logger.info("enter user name");
		loginPg.enterPassword("Password@3");
		logger.info("enter password");
		WebElement uplaodbtn= loginPg.login_btn();
		Thread.sleep(100);
		uplaodbtn.click();Thread.sleep(800);
		logger.info("click login");

		System.out.print("\n'SUCCESSFUL EXECUTION!!!");

	}

	// User should be able to search handle
	@Test(priority = 2, enabled = true)
	public void searchSource() throws InterruptedException {
		Thread.sleep(300);
		WebElement clickContent= targetPg.content_btn();
		clickContent.click();Thread.sleep(100);
		logger.info("click content");
		WebElement clickSource= targetPg.source_btn();
		clickSource.click();Thread.sleep(100);
		logger.info("click source");
		targetPg.enterSearchName("Bodice");
		logger.info("Got searched result");
		
	}
	
	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
	}
}

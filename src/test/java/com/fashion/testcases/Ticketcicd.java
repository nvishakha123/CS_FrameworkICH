package com.fashion.testcases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.fashion.pageobject.LogincicdPage;
import com.fashion.pageobject.TicketPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.fashion.utilities.ExtentListenerClass.class)
public class Ticketcicd {
	WebDriver driver;
	public LogincicdPage loginPg;
	public TicketPage ticketPg;
	public static Logger logger = LogManager.getLogger(Ticketcicd.class);

	@BeforeClass
	public void startChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

		loginPg = new LogincicdPage(driver);
		ticketPg = new TicketPage(driver);
		driver.get(Routescicd.linkcicd);
	}

	@Test(priority = 1, enabled = true)
	public void loginFunctionality() {
		loginPg.enterUserName(Routescicd.usernamecicd);
		logger.info("Entered username");

		loginPg.enterPassword(Routescicd.passwordcicd);
		logger.info("Entered password");

		loginPg.login_btn().click();
		logger.info("Clicked login");
	}

	@Test(priority = 2)
	public void testClickOnSubmit() throws InterruptedException {
		WebElement clickTicket = ticketPg.clickTicket();
		Thread.sleep(1000);

		if (clickTicket.isEnabled()) {
			clickTicket.click();
			ticketPg.clickTicketContent();
			logger.info("Clicked Ticket Content");

			ticketPg.clickTakeAction();
			logger.info("Clicked Take Action");

			ticketPg.clickInvalid();
			logger.info("Selected Invalid option");

			ticketPg.clickSubmit();
			logger.info("Clicked Submit");
			Thread.sleep(1000);
			ticketPg.clickConfirm();
			Thread.sleep(100);
			logger.info("Clicked Confirm");
		} else {
			System.out.println("Take action is disabled & not get clicked");
			driver.quit(); // Closes all windows and ends session
			Assert.fail("Condition failed. Closing the browser.");
			logger.info("Take action is disabled & not get clicked");
		}

	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

}

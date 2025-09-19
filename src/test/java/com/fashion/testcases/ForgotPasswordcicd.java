package com.fashion.testcases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fashion.pageobject.ForgotPage;
import com.fashion.pageobject.LogincicdPage;
import com.fashion.pageobject.TargetPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.fashion.utilities.ExtentListenerClass.class)
public class ForgotPasswordcicd {

	WebDriver driver = new ChromeDriver();
	WebDriverWait wait;
	public LogincicdPage loginPg;
	public ForgotPage forgotPg;
	public static Logger logger = LogManager.getLogger(ForgotPasswordcicd.class);

	@BeforeMethod
	public void startChrome() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		loginPg = new LogincicdPage(driver);
		forgotPg = new ForgotPage(driver);
		driver.get(Routescicd.linkcicd);
		logger = LogManager.getLogger("Seleniumcicd");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	}

	// Testcase to send link
	@Test(priority = 1, enabled = true)
	public void forgotPass() throws InterruptedException {
		WebElement clickForgot = forgotPg.forgot_btn();
		clickForgot.click();

		forgotPg.enterEmail(Routescicd.usernamecicd);

		WebElement clickSendLink = forgotPg.sendlink_btn();
		clickSendLink.click();

	}

	@Test(priority = 2, enabled = true)
	public void validation() throws InterruptedException {

		WebElement clickForgot = forgotPg.forgot_btn();
		clickForgot.click();

		forgotPg.enterEmail(" ");

		WebElement clickSendLink = forgotPg.sendlink_btn();
		clickSendLink.click();

	}

	@Test(priority = 3, enabled = true)
	public void enteredWrongEmail() throws InterruptedException {
		WebElement clickForgot = forgotPg.forgot_btn();
		clickForgot.click();

		forgotPg.enterEmail("vish@gmail.com");

		WebElement clickSendLink = forgotPg.sendlink_btn();
		clickSendLink.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='mt-4 text-sm text-red-500 text-center font-bold']")));
		Assert.assertTrue(errorMsg.isDisplayed(), "Error message was not displayed for wrong email!");

		String actualMsg = errorMsg.getText().trim();
		String success_message = "A reset link is sent to this mail ID.";
		Assert.assertEquals(actualMsg, success_message, "Wrong error message shown!");
		// Assert.fail("Failing the test case intentionally for wrong email input!");
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

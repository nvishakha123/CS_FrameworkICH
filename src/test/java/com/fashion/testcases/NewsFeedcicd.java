package com.fashion.testcases;

import java.time.Duration;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fashion.pageobject.LogincicdPage;
import com.fashion.pageobject.NewsFeedPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.fashion.utilities.ExtentListenerClass.class)
public class NewsFeedcicd {
	WebDriver driver = new ChromeDriver();
	public LogincicdPage loginPg;
	public NewsFeedPage newsfeedPg;
	public static Logger logger = LogManager.getLogger(NewsFeedcicd.class);

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

	@Test(priority = 2, enabled = true)
	public void testSearchFeed() throws InterruptedException {

		WebElement clickfeed= newsfeedPg.feed_btn();
		clickfeed.click();Thread.sleep(100);

		WebElement clicknewsfeed= newsfeedPg.newsfeed_btn();
		clicknewsfeed.click();Thread.sleep(100);
		newsfeedPg.enterSearchName("Economic");Thread.sleep(1200);

	}

	@Test(priority = 3, enabled = true)
	public void clickLinkFeed() throws InterruptedException {

		WebElement clickfeed= newsfeedPg.feed_btn();
		clickfeed.click();Thread.sleep(100);

		WebElement clicknewsfeed= newsfeedPg.newsfeed_btn();
		clicknewsfeed.click();Thread.sleep(100);

		WebElement new_click = driver.findElement(By.xpath("//a[@class='underline line-clamp-3 text-primary font-bold']"));
		new_click.click();

		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		// switch to new tab
		driver.switchTo().window(newTb.get(1));
		System.out.println("Page title of new tab: " + driver.getTitle());
		driver.close();
		// switch to parent window
		driver.switchTo().window(newTb.get(0));
	}
	
	@AfterTest
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		if (driver != null) {
			driver.quit();
		}
	}

}

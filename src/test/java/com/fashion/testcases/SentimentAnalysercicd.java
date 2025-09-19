package com.fashion.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fashion.pageobject.LogincicdPage;
import com.fashion.pageobject.SentimentPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.fashion.utilities.ExtentListenerClass.class)
public class SentimentAnalysercicd {
	WebDriver driver = new ChromeDriver();
	public LogincicdPage loginPg;
	public SentimentPage sentimentPg;
	public static Logger logger = LogManager.getLogger(SentimentAnalysercicd.class);

	@BeforeMethod
	public void startChrome() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		loginPg = new LogincicdPage(driver);
		sentimentPg = new SentimentPage(driver);
		driver.get(Routescicd.linkcicd);
		logger = LogManager.getLogger("Seleniumcicd");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	}

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
	public void testenterTextAndGenerateResult() throws InterruptedException, AWTException {
		Thread.sleep(300);
		WebElement clickAnalyser = sentimentPg.analyser_btn();
		clickAnalyser.click();
		WebElement clickSentiment = sentimentPg.sentiment_btn();
		clickSentiment.click();

		sentimentPg.enterInputName("Trends in Mumbai");

		WebElement clickgentxt = sentimentPg.gen_btn();
		clickgentxt.click();
		Thread.sleep(14000);

		WebElement clickclearall = sentimentPg.clearall_btn();
		clickclearall.click();
	}

	@Test(priority = 3, enabled = true)
	public void validationForEmptyUpload() throws InterruptedException, AWTException {

		WebElement clickAnalyser = sentimentPg.analyser_btn();
		clickAnalyser.click();
		WebElement clickSentiment = sentimentPg.sentiment_btn();
		clickSentiment.click();

		// 1st Image upload
		WebElement validateImage1 = driver.findElement(By.xpath("//div[@class='cursor-pointer relative '][1]"));
		// Check if the upload field is empty
		String filePath = validateImage1.getAttribute("value");

		if (filePath == null || filePath.isEmpty()) {
			System.out.println("Upload field is empty.");
			logger.info("Upload field is empty.");
		} else {
			System.out.println("File has been selected: " + filePath);
			logger.info("Upload field is empty." + filePath);
		}Thread.sleep(2000);}

	@Test(priority = 4, enabled = true)
	public void singleUploadImage() throws InterruptedException, AWTException {
		WebElement clickAnalyser = sentimentPg.analyser_btn();
		clickAnalyser.click();
		WebElement clickSentiment = sentimentPg.sentiment_btn();
		clickSentiment.click();

		WebElement clickImage = sentimentPg.image1_btn();
		clickImage.click();
		Robot rb = new Robot();
		rb.delay(2000);
		StringSelection ss = new StringSelection("C:\\Users\\Vishakha\\Downloads\\bode_18403173292140063.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='cursor-pointer relative '][1]")));
		Thread.sleep(3000);
		WebElement clickgentxt = sentimentPg.gen_btn();
		clickgentxt.click();
		Thread.sleep(8000);}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

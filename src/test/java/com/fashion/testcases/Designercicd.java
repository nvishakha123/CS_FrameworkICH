package com.fashion.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fashion.pageobject.DesignerPage;
import com.fashion.pageobject.LogincicdPage;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.fashion.utilities.ExtentListenerClass.class)
public class Designercicd {
	WebDriver driver;
	public LogincicdPage loginPg;
	public DesignerPage designerPg;
	public static Logger logger = LogManager.getLogger(Designercicd.class);

	@BeforeClass
	public void startChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

		loginPg = new LogincicdPage(driver);
		designerPg = new DesignerPage(driver);
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

	@Test(priority = 2, enabled = true)
	public void textSearch() throws InterruptedException, AWTException {
		designerPg.enterInputName("Black Dress");

		WebElement clickSearch = designerPg.clicksearch();
		clickSearch.click();
		Thread.sleep(2000);
	}

	@Test(priority = 3, enabled = true)
	public void imageSearch() throws InterruptedException, AWTException {
		
		WebElement click_img = designerPg.clickimage();
		click_img.click();
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

		Thread.sleep(1000);
		WebElement clickSearch = designerPg.clicksearch();
		clickSearch.click();
		Thread.sleep(2000);
		
		try {
			WebElement errorMsg = driver.findElement(By.xpath("//div[contains(text(),'Error while fetching posts')]"));
			if (errorMsg.isDisplayed()) {
				Assert.fail("Test failed: Error popup appeared - " + errorMsg.getText());
				logger.info("Test failed: Error popup appeared - ");
				
			}
		} catch (NoSuchElementException e) {
			
			System.out.println("No error popup, test continues normally.");
			logger.info("No error popup, test continues normally.");
			
		}
	}

	@Test(priority = 4, enabled = true)
	public void functionality_downlaodAndCopy() throws InterruptedException, AWTException {
		driver.navigate().refresh();
	    Thread.sleep(2000);
		WebElement click_download = designerPg.clickdownload();
		click_download.click();

		WebElement click_download1 = designerPg.clickdownload1();
		click_download1.click();
		WebElement click_cross = designerPg.clickcross();
		click_cross.click();

		WebElement click_copy = designerPg.clickcopy();
		click_copy.click();
		
	}

	@AfterClass(alwaysRun = true)  
    public void teardown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }

}

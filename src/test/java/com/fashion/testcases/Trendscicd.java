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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fashion.pageobject.LogincicdPage;
import com.fashion.pageobject.TicketPage;
import com.fashion.pageobject.TrendsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Trendscicd {
	WebDriver driver;
	public LogincicdPage loginPg;
	public TrendsPage trendsPg;
	public static Logger logger = LogManager.getLogger(Trendscicd.class);

	@BeforeClass
	public void startChrome() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20000));

		loginPg = new LogincicdPage(driver);
		trendsPg = new TrendsPage(driver);
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
	public void openTrendsPage() throws InterruptedException {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(150));

		WebElement designer_page = driver.findElement(By.xpath("//span[text()='Designer Page']"));

		if (designer_page.isDisplayed() && designer_page.isEnabled()) {
			designer_page.click();
			System.out.println("Designer page get clicked");

			WebElement dropdown = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='relative']")));
			dropdown.click();

			WebElement fashion = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Fashion']")));
			fashion.click();

			WebElement women = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Women']")));
			women.click();

			WebElement category = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select Category']")));
			category.click();

			WebElement ethnic_rtw = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ethnic RTW']")));
			ethnic_rtw.click();

			// click trends
			WebElement open_trends = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class='flex flex-col items-center mt-4']//*[name()='svg']//*[name()='path' and contains(@d,'M0.999998 ')]")));
			open_trends.click();

			WebElement select_product_type = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select product type']")));
			select_product_type.click();

			WebElement select_product_type_name = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Kurtas']")));
			select_product_type_name.click();

			WebElement material = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Pattern']")));
			material.click();

			WebElement styling_details = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Run Analysis']")));
			styling_details.click();

			Thread.sleep(10000);

		} else {
			System.out.println("Designer page get clicked");
		}
			
	}
	
	
	@Test(priority = 3, enabled = true)
	public void openExpandOverallAnlysis() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(150));

		WebElement designer_page = driver.findElement(By.xpath("//span[text()='Designer Page']"));

		if (designer_page.isDisplayed() && designer_page.isEnabled()) {
			designer_page.click();
			System.out.println("Designer page get clicked");

			WebElement dropdown = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='relative']")));
			dropdown.click();

			WebElement fashion = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Fashion']")));
			fashion.click();

			WebElement women = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Women']")));
			women.click();

			WebElement category = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select Category']")));
			category.click();

			WebElement ethnic_rtw = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Ethnic RTW']")));
			ethnic_rtw.click();

			// click trends
			WebElement open_trends = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[@class='flex flex-col items-center mt-4']//*[name()='svg']//*[name()='path' and contains(@d,'M0.999998 ')]")));
			open_trends.click();

			WebElement select_product_type = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Select product type']")));
			select_product_type.click();

			WebElement select_product_type_name = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Kurtas']")));
			select_product_type_name.click();

			WebElement material = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Pattern']")));
			material.click();

			WebElement styling_details = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Run Analysis']")));
			styling_details.click();

			Thread.sleep(8000);

			WebElement overall_analysis = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//div[contains(@class,'my-1 relative')]//div[contains(@class,'cursor-pointer')]//*[name()='svg']")));
			overall_analysis.click();

			WebElement overall_analysis_expand = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Expand']")));
			overall_analysis_expand.click();

		} else {
			System.out.println("Designer page get clicked");
		}

	}
	
	
	
	
	
	
	
	
	
	
	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

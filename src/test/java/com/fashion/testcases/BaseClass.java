package com.fashion.testcases;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.fashion.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
  
	ReadConfig readConfig = new ReadConfig();
	
	String url = readConfig.getBaseUrl(); 
	String browser = readConfig.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger = LogManager.getLogger(BaseClass.class);
	
	@BeforeClass
	public void setUp() 
	{
		//String browser = "chorme";
		
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		default:
			driver =null;
			break;
		}
		
		//implicit wait of 10 sec
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//for logging
		logger = LogManager.getLogger("Seleniumcicd");
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
	
}

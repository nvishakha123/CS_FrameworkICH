package com.fashion.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fashion.pageobject.LogincicdPage;

@Listeners(com.fashion.utilities.ExtentListenerClass.class)
public class TC_LoginPage extends BaseClass{
	
	@Test(priority=1, enabled=true)
	public void verifyLogin() throws InterruptedException {
		logger.info("*******************************Login start********************************************");
		//open url
		driver.get(url);
		logger.info("url opened");
		System.out.println("Hello from test");
		Thread.sleep(100);
		LogincicdPage logincicdPg = new LogincicdPage(driver);
		logincicdPg.enterUserName("vishakha.nandanwar@kreedalabs.com");
		logger.info("username entered");
		System.out.println("Hello from test1");
		logincicdPg.enterPassword("Password@3");
		logger.info("password entered");
		logincicdPg.login_btn();
		logger.info("login button clicked");
		System.out.println("Hello from test2");
		Thread.sleep(800);
	}
	
	@Test(priority=2, enabled=true)
	public void verifyLoginwithinvalidcredentials() throws InterruptedException {
		
		//open url
		driver.get(url);
		logger.info("url opened");
		Thread.sleep(100);
		LogincicdPage logincicdPg = new LogincicdPage(driver);
		logincicdPg.enterUserName("vish2727@gmail.com");
		logger.info("wrong username entered");
		logincicdPg.enterPassword("Pass1");
		logger.info("wrong password entered");
		logincicdPg.login_btn();
		logger.info("login button clicked");
		Thread.sleep(800);
	}
	
}

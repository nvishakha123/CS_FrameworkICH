package com.fashion.testcases;

import org.testng.annotations.Test;

import com.fashion.pageobject.LogincicdPage;

public class TC_LoginPage extends BaseClass{
	
	@Test(priority=1, enabled=true)
	public void verifyLogin() throws InterruptedException {
		
		//open url
		driver.get(url);
		logger.info("url opened");
		Thread.sleep(100);
		LogincicdPage logincicdPg = new LogincicdPage(driver);
		logincicdPg.enterUserName("vishakha.nandanwar@kreedalabs.com");
		logger.info("username entered");
		logincicdPg.enterPassword("Password@3");
		logger.info("password entered");
		logincicdPg.login_btn();
		logger.info("login button clicked");
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
		logger.info("username entered");
		logincicdPg.enterPassword("Pass1");
		logger.info("password entered");
		logincicdPg.login_btn();
		logger.info("login button clicked");
		Thread.sleep(800);
	}
	
}

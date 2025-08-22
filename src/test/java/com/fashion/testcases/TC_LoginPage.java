package com.fashion.testcases;

import org.testng.annotations.Test;

import com.fashion.pageobject.LogincicdPage;

public class TC_LoginPage extends BaseClass{
	
	@Test
	public void verifyLogin() {
		
		//open url
		driver.get(url);
		logger.info("url opened");
		
		LogincicdPage logincicdPg = new LogincicdPage(driver);
		logincicdPg.enterUserName("vishakha.nandanwar@kreedalabs.com");
		logger.info("username entered");
		logincicdPg.enterPassword("Password@3");
		logger.info("password entered");
		logincicdPg.loginBtn();
		logger.info("login button cliked");
	}

}

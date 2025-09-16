package com.fashion.pageobject;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogincicdPage {

	WebDriver ldriver;

	public LogincicdPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

	 @FindBy(id= "email")
	  WebElement username;
	 @FindBy(id = "password")
	 WebElement password;
		/*
		 * @FindBy(xpath = "//button[text()='Login']") WebElement sbt_btn;
		 */
	 
     public void enterUserName(String uname) {
		 username.sendKeys(uname);
		
     }
		
		public void enterPassword(String pwd) {
			password.sendKeys(pwd);
		}
		
		/*
		 * public void loginBtn() { sbt_btn.click(); }
		 */
	
		
		By click_login_btn = By.xpath("//button[text()='Login']");

		public WebElement login_btn() {
			WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
			return wait.until(ExpectedConditions.visibilityOfElementLocated(click_login_btn));
		}
}

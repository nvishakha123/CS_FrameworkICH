package com.fashion.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPage {
	WebDriver ldriver;

	public ForgotPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	By click_forgotPass = By.xpath("//a[text()='Forgot Password?']");
	public WebElement forgot_btn() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(click_forgotPass));
	}
	
	@FindBy(xpath = "//input[@placeholder='Enter email']")
	WebElement enteremail;
	public void enterEmail(String uname) {
		enteremail.sendKeys(uname);
		
    }
	
	By click_sendlink = By.xpath("//button[text()='Send Link']");
	public WebElement sendlink_btn() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(click_sendlink));
	}

}

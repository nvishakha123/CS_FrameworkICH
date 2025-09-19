package com.fashion.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsFeedPage {
	WebDriver ldriver;

	public NewsFeedPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	By click_feed = By.xpath("//span[text()='Feed']");
	public WebElement feed_btn() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(click_feed));
	}
	
	By click_newsfeed = By.xpath("//span[text()='News Feed']");
	public WebElement newsfeed_btn() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(click_newsfeed));
	}
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchfeed;
	public void enterSearchName(String uname) {
		searchfeed.sendKeys(uname);
		
    }
}

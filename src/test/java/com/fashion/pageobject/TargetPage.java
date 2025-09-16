package com.fashion.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TargetPage {
	WebDriver ldriver;

	public TargetPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	By click_content = By.xpath("//li[@class='flex items-center py-4 px-2 cursor-pointer rounded-2xl mb-2 text-secondary hover:bg-gray'][1]");
	public WebElement content_btn() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(click_content));
	}
	
	By click_source = By.xpath("//span[text()='Sources']");
	public WebElement source_btn() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(click_source));
	}
	
	@FindBy(xpath = "//input[@placeholder='Search Sources']")
	WebElement search;
	public void enterSearchName(String uname) {
		search.sendKeys(uname);
		
    }
}

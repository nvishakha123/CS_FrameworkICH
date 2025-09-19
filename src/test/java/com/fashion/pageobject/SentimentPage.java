package com.fashion.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SentimentPage {
	WebDriver ldriver;

	public SentimentPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	By click_Analyser = By.xpath("//span[text()='Generative Feature']");
	public WebElement analyser_btn() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(click_Analyser));
	}
	
	By click_sentiment_analyser = By.xpath("//span[text()='Sentiment Analyser']");
	public WebElement sentiment_btn() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(click_sentiment_analyser));
	}
	
	@FindBy(xpath = "//textarea[@class='outline-none flex-1 text-secondary font-avenir font-normal resize-none h-full pl-2']")
	WebElement textenterinput;
	public void enterInputName(String uname) {
		textenterinput.sendKeys(uname);
		
    }
	
	
	By click_gen_analyser = By.xpath("//p[text()='Generate']");
	public WebElement gen_btn() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(click_gen_analyser));
	}
	
	By click_clearall = By.xpath("//div[text()='Clear All']");
	public WebElement clearall_btn() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(click_clearall));
	}
	
	
	////////////image////////////////
	
	
	By click_image1 = By.xpath("//div[@class='cursor-pointer relative '][1]");
	public WebElement image1_btn() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(click_image1));
	}
}

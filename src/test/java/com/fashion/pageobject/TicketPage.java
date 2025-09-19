package com.fashion.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicketPage {
	WebDriver ldriver;
	WebDriverWait wait;

	public TicketPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
		this.wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
	}
	
	    private By ticketBtn = By.xpath("//a[@href='/tickets']");
	    private By ticketContentBtn = By.xpath("(//div[@class='flex items-stretch bg-white hover:bg-lightGray text-sm border-b-2 border-gray-200 cursor-pointer'])[3]");
	    private By takeActionBtn = By.xpath("//span[text()='Take Action']");
	    private By invalidBtn = By.xpath("//input[@id='invalid']");
	    private By submitBtn = By.xpath("//button[text()='Submit']");
	    private By confirmBtn = By.xpath("//div[text()='Confirm']"); 

	    public WebElement clickTicket() {
	    	 WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
	    	    return wait.until(ExpectedConditions.elementToBeClickable(ticketBtn));
	    }

	    public void clickTicketContent() {
	        wait.until(ExpectedConditions.elementToBeClickable(ticketContentBtn)).click();
	    }

	    public void clickTakeAction() {
	        wait.until(ExpectedConditions.elementToBeClickable(takeActionBtn)).click();
	    }

	    public void clickInvalid() {
	        wait.until(ExpectedConditions.elementToBeClickable(invalidBtn)).click();
	    }

	    public void clickSubmit() {
	        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
	    }

	    public void clickConfirm() {
	        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn)).click();
	    }
	}
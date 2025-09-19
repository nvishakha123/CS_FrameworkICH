package com.fashion.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DesignerPage {
	WebDriver ldriver;
	WebDriverWait wait;

	public DesignerPage(WebDriver rDriver) {
		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
		this.wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
	}
	
	private @FindBy(xpath = "//input[@class='w-full pl-3 text-md outline-none']")
	WebElement textenter;
    private By searchBtn = By.xpath("//*[local-name()='svg' and @class='w-6 h-6 cursor-pointer ml-3 mr-1 ']");
    private By imageBtn = By.xpath("//div[@class='cursor-pointer']");
    private By dwndBtn = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/main/div/div/div[2]/div[2]/div/div[1]/div[1]/div[3]/div[3]");
    private By dwndBtn1 = By.xpath("//button[text()='Download']");
    private By crossbtn = By.xpath("//button[@class='text-gray-500 hover:text-gray-700']");
    private By copyBtn = By.xpath("//div[@class='bg-white flex w-5 h-5 items-center justify-center rounded-full cursor-pointer']");
    
    
    public WebElement clicksearch() {
   	 WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
   	    return wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
   }
    
    public void enterInputName(String uname) {
    	textenter.clear(); 
    	textenter.sendKeys(uname);
		
    }
    
    public WebElement clickimage() {
    	textenter.clear(); 
      	 WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
      	    return wait.until(ExpectedConditions.elementToBeClickable(imageBtn));
      }
    
    public WebElement clickdownload() {
      	 WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
      	    return wait.until(ExpectedConditions.elementToBeClickable(dwndBtn));
      }
    
    public WebElement clickdownload1() {
      	 WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(1000));
      	    return wait.until(ExpectedConditions.elementToBeClickable(dwndBtn1));
      }
    
    public WebElement clickcross() {
      	 WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(1000));
      	    return wait.until(ExpectedConditions.elementToBeClickable(crossbtn));
      }
    
    public WebElement clickcopy() {
      	 WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(1200));
      	    return wait.until(ExpectedConditions.elementToBeClickable(copyBtn));
      }
}

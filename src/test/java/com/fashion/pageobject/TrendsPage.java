package com.fashion.pageobject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrendsPage {
	WebDriver ldriver;
	WebDriverWait wait;

	public TrendsPage(WebDriver rDriver) {

		ldriver = rDriver;
		PageFactory.initElements(rDriver, this);
		this.wait = new WebDriverWait(ldriver, Duration.ofSeconds(1000));
	}
	 private By dropdwnBtn = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/main/div/div/div[1]/div/div[3]/div[2]/div");
	    private By fashion = By.xpath("(//button[text()='Fashion']");
	    private By women = By.xpath("//input[@value='Women']");
	    private By category = By.xpath("//span[text()='Select Category']");
	    private By ethnic_rtw = By.xpath("//button[text()='Ethnic RTW']");
	    private By open_trends = By.xpath("//div[@class='flex flex-col items-center mt-4']//*[name()='svg']//*[name()='path' and contains(@d,'M0.999998 ')]"); 
	    
	    private By select_product_type = By.xpath("//span[text()='Select product type']");
	    private By select_product_type_name = By.xpath("//button[text()='Kurtas']");
	    private By material = By.xpath("//div[text()='Pattern']");
	    private By styling_details = By.xpath("//button[text()='Run Analysis']");
	   
	    
	    public WebElement clickDropdown() {
	    	 WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
	    	    return wait.until(ExpectedConditions.elementToBeClickable(dropdwnBtn));
	    }

	    public WebElement clickFashion() {
	    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
    	    return wait.until(ExpectedConditions.elementToBeClickable(fashion));
	    }

	    public WebElement clickWomen() {
	    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
    	    return wait.until(ExpectedConditions.elementToBeClickable(women));
	    }

	    public WebElement clickCategory() {
	    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
    	    return wait.until(ExpectedConditions.elementToBeClickable(category));
	    }

	    public WebElement clickEthnicRTW() {
	    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
    	    return wait.until(ExpectedConditions.elementToBeClickable(ethnic_rtw));
	    }

	    public WebElement clickOpentrends() {
	    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
    	    return wait.until(ExpectedConditions.elementToBeClickable(open_trends));
	    }
	    
	    public WebElement clickSelectProductType() {
	    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
    	    return wait.until(ExpectedConditions.elementToBeClickable(select_product_type));
	    }
	    
	    public WebElement clickSelectProductName() {
	    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
    	    return wait.until(ExpectedConditions.elementToBeClickable(select_product_type_name));
	    }
	    
	    public WebElement clickMaterial() {
	    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
    	    return wait.until(ExpectedConditions.elementToBeClickable(material));
	    }
	    
	    public WebElement clickStylingDetails() {
	    	WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(100));
    	    return wait.until(ExpectedConditions.elementToBeClickable(styling_details));
	    }
}

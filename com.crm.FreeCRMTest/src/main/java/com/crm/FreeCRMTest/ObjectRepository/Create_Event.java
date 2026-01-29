package com.crm.FreeCRMTest.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Event {
	WebDriver driver;
	public Create_Event(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@class='ui basic icon button aux-custom-btn']")
	private WebElement clickEventBtn;
	@FindBy(xpath="//input[@name='title']")
	private WebElement eventTitle;
	@FindBy(xpath="(//i[@class='dropdown icon'])[2]")
	private WebElement eventcate;
	@FindBy(xpath="//span[text()='Important']")
	private WebElement eventimp;
	@FindBy(xpath="//button[@class='ui linkedin button']")
	private WebElement esave;
	
	public void createEvent(String ename)
	{
		clickEventBtn.click();
		eventTitle.sendKeys(ename);
		eventcate.click();
		eventimp.click();
		esave.click();
		
		
	}
	

}

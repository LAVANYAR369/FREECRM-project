package com.crm.FreeCRMTest.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.FreeCRMTest.WebDriverUtility.WebDriverUtility;

public class createCalender {
	WebDriver driver;
	 WebDriverUtility WD=new WebDriverUtility();
	public createCalender(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath="//i[@class='calendar icon']") 
	 private WebElement moveToCalenderBtn;
	  
	  @FindBy(xpath="(//i[@class='edit icon'])[1]") 
	  private WebElement clickCreateBtn;
	  @FindBy(xpath="//input[@name='title']") 
	  private WebElement eventName;
	  @FindBy(xpath="//i[@class='save icon']") 
	  private WebElement clickSaveBtn;
	  @FindBy(xpath="(//i[@class='add icon'])[1]") 
	  private WebElement clickeveBtn;
	  @FindBy(xpath="//textarea[@rows='3']") 
	  private WebElement adddescForm;
	  @FindBy(xpath="//button[@class='ui green button']") 
	  private WebElement dSaveBtn;
	  
	  public void createCalenderEvent(String eveName,String desc)
	  {
		  moveToCalenderBtn.click();
		  clickCreateBtn.click();
		  eventName.sendKeys(eveName);
		  clickSaveBtn.click();
		  clickeveBtn.click();
		  adddescForm.sendKeys(desc);
		  dSaveBtn.click();
	  }
	

	
}

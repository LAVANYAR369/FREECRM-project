package com.crm.FreeCRMTest.ObjectRepository;

import java.util.concurrent.ConcurrentHashMap.KeySetView;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Task {
	WebDriver driver;
	public Create_Task(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="(//i[@class='tasks icon'])[2]")
	private WebElement clickTaskIcon;	
	@FindBy(xpath="(//button[@class='ui basic icon button'])[3]")
	private WebElement clickTaskcreateIcon;
	@FindBy(xpath="//input[@name='title']")
	private WebElement taskTitle;
	@FindBy(xpath="//div[@class='ui fluid selection dropdown']")
	private WebElement taskAssignto;
	@FindBy(xpath="(//div[@class='selected item'])[2]")
	private WebElement taskAssigname;
	@FindBy(xpath="(//div[@class='ui selection dropdown'])[1]")
	private WebElement tasktype;
	@FindBy(xpath="//input[@class='calendarField react-datepicker-ignore-onclickoutside']")
	private WebElement duedate;
	@FindBy(xpath="//span[text()='Customer Support']")
	private WebElement duedateselect;
	@FindBy(xpath="(//input[@aria-autocomplete='list'])[3]")
	private WebElement createDeal;
	@FindBy(xpath="//span[text()='Customer Support']")
	private WebElement tasktypeCustomer;
	@FindBy(xpath="(//input[@class='search'])[2]")
	private WebElement taskCompany;
	@FindBy(xpath="//i[@class='save icon']")
	private WebElement taskSave;
	
	public void createTask(String title,String company,String deal)
	{
		clickTaskIcon.click();
		//clickTaskcreateIcon.click();
		taskTitle.sendKeys(title);
		taskAssignto.click();
		taskAssigname.click();
		tasktype.click();
		tasktypeCustomer.click();
		
		taskCompany.sendKeys(company,Keys.ENTER);
		taskSave.click();
		
	}

}

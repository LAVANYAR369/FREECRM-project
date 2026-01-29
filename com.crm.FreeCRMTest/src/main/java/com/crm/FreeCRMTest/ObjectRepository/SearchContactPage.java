package com.crm.FreeCRMTest.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchContactPage {
	WebDriver driver;
	public SearchContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement SearchIcon;
	@FindBy(xpath="//a[text()='malar ']")
	private WebElement clickconta;
	@FindBy(xpath="(//i[@class='tasks icon'])[2]")
	private WebElement clickAddEvent;
	@FindBy(xpath="//input[@name='title']")
	private WebElement taskTitle;
	@FindBy(xpath="(//div[@role='listbox'])[3]")
	private WebElement assignedToclick;
	
	@FindBy(xpath="(//div[text()='Select'])[1]")
	private WebElement assignedTo;
	@FindBy(xpath="(//div[@role='listbox'])[4]")
	private WebElement type1;
	@FindBy(xpath="//span[text()='Customer Support']")
	private WebElement type;
	@FindBy(xpath="//i[@class='save icon']")
	private WebElement savebtn;
	
	public void searchConTask(String name,String title)
	{
		
		SearchIcon.click();
		Actions act=new Actions(driver);
		act.sendKeys(name,Keys.ENTER).perform();
		clickconta.click();
		clickAddEvent.click();
		taskTitle.sendKeys(title);
		assignedToclick.click();
		assignedTo.click();
		//type1.click();
		//type.click();
		savebtn.click();
	}
	

}

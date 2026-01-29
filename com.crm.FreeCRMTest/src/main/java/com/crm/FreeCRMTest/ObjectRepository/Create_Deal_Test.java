package com.crm.FreeCRMTest.ObjectRepository;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Create_Deal_Test {
	WebDriver driver;
	public Create_Deal_Test(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Contacts']")
	private WebElement moveToContactBtn;
	@FindBy(xpath="//div[@name='view']")
	private WebElement moveToConRec;
	@FindBy(xpath="(//div[@role='option'])[1]")
	private WebElement selContact;
	
	@FindBy(xpath="(//i[@class='add icon'])[3]")
	private WebElement selDealIcon;
	@FindBy(xpath="//input[@name='title']")
	private WebElement selDealName;
	@FindBy(xpath="(//i[@class='search icon'])[1]")
	private WebElement selcompany;
	@FindBy(xpath="//span[text()='Qualify']")
	private WebElement selqualify;
	@FindBy(xpath="//input[@name='amount']")
	private WebElement selAmount;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement DSavebtn;
	
	
	@FindBy(xpath="(//span[text()='Deals'])[1]")
	private WebElement selectDealIcon;
@FindBy(xpath="//button[text()='Create']")
private WebElement selDealPlusIcon;
	@FindBy(xpath="//div[@class='ui fluid selection dropdown']")
	private WebElement selDAssignto;
	@FindBy(xpath="(//div[@class='selected item'])[2]")
	private WebElement selDAssigname;
	@FindBy(xpath="(//input[@class='search'])[1]")
	private WebElement selComp;
	@FindBy(xpath="(//input[@class='search'])[1]")
	private WebElement selCompName;
	
	public void createDeal(String dName,String comname,String damount)
	{
		moveToContactBtn.click();
		moveToConRec.click();
		selContact.click();
		selDealIcon.click();
		selDealName.sendKeys(dName);
		selcompany.click();
		Actions act=new Actions(driver);
		act.sendKeys(comname,Keys.ENTER).perform();

		selAmount.sendKeys(damount,Keys.TAB,Keys.TAB);
		selqualify.click();
		
		DSavebtn.click();
	}

	public void createDealWithContact(String dName,String compName)
	{
		selectDealIcon.click();
			selDealPlusIcon.click();
		selDealName.sendKeys(dName);
		selDAssignto.click();
		selDAssigname.click();
		selComp.click();
		selCompName.sendKeys(compName,Keys.ENTER);
		DSavebtn.click();
	}

}

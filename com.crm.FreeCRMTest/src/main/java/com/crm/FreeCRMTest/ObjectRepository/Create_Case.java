package com.crm.FreeCRMTest.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.FreeCRMTest.WebDriverUtility.WebDriverUtility;

public class Create_Case {
	WebDriverUtility wd=new WebDriverUtility();
	WebDriver driver;
	public Create_Case(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//span[text()='Contacts']")
	private WebElement moveToContactBtn;
	@FindBy(xpath="//span[text()='Cases']")
	private WebElement clickCase;
	@FindBy(xpath="(//button[@class='ui linkedin button'])[5]")
	private WebElement clickCreateCase;
	@FindBy(xpath="//input[@name='title']")
	private WebElement campName;
	@FindBy(xpath="//div[@class='ui fluid selection dropdown']")
	private WebElement Assignto;
	@FindBy(xpath="(//div[@class='selected item'])[2]")
	private WebElement Assigname;
	@FindBy(xpath="(//input[@aria-autocomplete='list'])[1]")
	private WebElement contactBtn;
	@FindBy(xpath="//div[@name='company']/input[@class='search']")
	private WebElement companyBtn;
	@FindBy(xpath="//div[@name='deal']/input[@class='search']")
	private WebElement dealBtn;
	@FindBy(xpath="//div[@name='type']/i[@class='dropdown icon']")
	private WebElement typeBtn;
	@FindBy(xpath="//span[text()='General Support']")
	private WebElement typeBtnsel;
	@FindBy(xpath="//div[@name='priority' and @class='ui selection dropdown']")
	private WebElement priorityBtn;
	@FindBy(xpath="//span[text()='Normal']")
	private WebElement priorityNormalBtn;
	@FindBy(xpath="//input[@name='identifier']")
	private WebElement identifier;
	@FindBy(xpath="//button[@class='ui linkedin button']")
	private WebElement casesave;
	
	public void createCase(String cname,String conName,String comName,String dealName,String typeName,String idenName)
	{
		//wd.waitForElementPresent(driver, Assigname);
		Actions act=new Actions(driver);
		act.moveToElement(moveToContactBtn).perform();
		clickCase.click();
		clickCreateCase.click();
		campName.sendKeys(cname);
		Assignto.click();
		Assigname.click();
		contactBtn.click();
		contactBtn.sendKeys(conName,Keys.ENTER);
		companyBtn.click();
		companyBtn.sendKeys(comName,Keys.ENTER);
		dealBtn.click();
		dealBtn.sendKeys(dealName,Keys.ENTER);
		typeBtn.click();
		typeBtnsel.click();
		priorityBtn.click();
		priorityNormalBtn.click();
		identifier.sendKeys(idenName);
		casesave.click();
		
	}
}

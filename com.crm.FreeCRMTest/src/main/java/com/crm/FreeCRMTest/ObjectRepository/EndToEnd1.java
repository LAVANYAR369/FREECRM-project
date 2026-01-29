package com.crm.FreeCRMTest.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EndToEnd1 {
	WebDriver driver;
	public EndToEnd1(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='Contacts']")
	private WebElement moveToContactBtn;

	@FindBy(xpath="//i[@class='users icon']")
	private WebElement clickOnProduct;
	@FindBy(xpath="//button[text()='Create']")
	private WebElement concreatebtn;
	@FindBy(xpath="//input[@name='first_name']")
	private WebElement confirstname;
	@FindBy(xpath="//input[@name='last_name']")
	private WebElement conlastname;
	@FindBy(xpath="(//i[@class='search icon'])[1]")
	private WebElement compname;
	@FindBy(xpath="//input[@placeholder='Email address']")
	private WebElement conemailid;
	@FindBy(xpath="//input[@name='position']")
	private WebElement conposition;
	@FindBy(xpath="//button[text()='Save']")
	private WebElement consave;

	@FindBy(xpath="//span[text()='Contacts']")
	private WebElement moveToDealBtn;
	@FindBy(xpath="//div[@name='view']")
	private WebElement moveToConRec;
	@FindBy(xpath="(//div[@role='option'])[1]")
	private WebElement selContact;
	
	@FindBy(xpath="//a[text()='Deals']")
	private WebElement clickDealBtn;
	@FindBy(xpath="//i[@class='add icon']")
	private WebElement clickPlusDealBtn;
	@FindBy(xpath="//input[@name='title']")
	private WebElement dealName;
	
	@FindBy(xpath="//input[@name='title']")
	private WebElement selDealName;
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
	@FindBy(xpath="//button[text()='Save']")
	private WebElement dSaveBtn;
	@FindBy(xpath="(//i[@class='settings icon'])[1]")
	private WebElement clickSetting;
	@FindBy(xpath="//span[text()='Invoices']")
	private WebElement invoicebtn;
	@FindBy(xpath="//button[text()='Create']")
	private WebElement invoiceCreatebtn;
	
	@FindBy(xpath="(//input[@aria-autocomplete='list'])[1]")
	private WebElement deal;
	@FindBy(xpath="(//input[@aria-autocomplete='list'])[2]")
	private WebElement company;
	@FindBy(xpath="(//input[@aria-autocomplete='list'])[3]")
	private WebElement contact;
	@FindBy(xpath="//input[@name='description']")
	private WebElement invoicedes;
	@FindBy(xpath="//input[@name='price']")
	private WebElement invoicePri;
	@FindBy(xpath="//input[@name='discount']")
	private WebElement invoiceDis;
	public void PerformCreateContact(String fname,String lname,String comp,String email,String phone,String position,String dname,String inDeal,String inComp,String inContact,String indesc,String inPrice,String inDisc)
	{
		Actions act=new Actions(driver);
		act.moveToElement(moveToContactBtn).perform();
		
		moveToContactBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(moveToContactBtn));
		concreatebtn.click();
		confirstname.sendKeys(fname);
		conlastname.sendKeys(lname);
		compname.click();
		
		act.sendKeys(comp,Keys.ENTER).perform();

		conemailid.sendKeys(email);

		act.moveToElement(conposition).perform();
		conposition.sendKeys(position);
		consave.click();
		clickDealBtn.click();
		clickPlusDealBtn.click();
		dealName.sendKeys(dname);
		selDAssignto.click();
		selDAssigname.click();
		selComp.click();
		selCompName.sendKeys(comp);
		dSaveBtn.click();
		clickSetting.click();
		invoicebtn.click();
		invoiceCreatebtn.click();
		deal.sendKeys(inDeal);

		company.sendKeys(inComp);
		contact.sendKeys(inContact);
		invoicedes.sendKeys(indesc);
		invoicePri.sendKeys(inPrice);
		invoiceDis.sendKeys(inDisc);
		dSaveBtn.click();
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
		dSaveBtn.click();
		
	}

	

}

package com.crm.FreeCRMTest.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Company {
	WebDriver driver;
	public Create_Company(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//i[@class='building icon']")
	private WebElement moveToCompanyBtn;

	@FindBy(xpath="(//button[@class='ui linkedin button'])[3]")
	private WebElement clickCreateCompany;
	
	@FindBy(xpath="(//input[@autocomplete='new-password'])[1]")
	private WebElement companyName;
	@FindBy(xpath="//input[@name='state']")
	private WebElement companyAddress;
	@FindBy(xpath="//input[@name='num_employees']")
	private WebElement companyEmp;
	@FindBy(xpath="//i[@class='save icon']")
	private WebElement companyCreateSave;
	@FindBy(xpath="//input[@placeholder='Number']")
	private WebElement companyPhoneNo;
	@FindBy(xpath="//input[@name='url']")
	private WebElement companyWebsite;
	@FindBy(xpath="//input[@name='industry']")
	private WebElement companyIndustry;
	
	
	
	@FindBy(xpath="//i[@class='user icon']")
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
	@FindBy(xpath="//button[@class='ui linkedin button']")
	private WebElement consave;

	
	public void createCompany(String compName,String website,String compAdd,String phNo,String compEmp,String industry)
	{
		moveToCompanyBtn.click();
		clickCreateCompany.click();
		companyName.sendKeys(compName);
		companyWebsite.sendKeys(website);
		companyAddress.sendKeys(compAdd);
		companyPhoneNo.sendKeys(phNo);
		companyEmp.sendKeys(compEmp);
		companyIndustry.sendKeys(industry);
		companyCreateSave.click();
	}
	public void PerformCreateContact(String fname,String lname,String comp,String email,String phone,String position)
	{
		
		concreatebtn.click();
		confirstname.sendKeys(fname);
		conlastname.sendKeys(lname);
		compname.click();
		Actions act=new Actions(driver);
		act.sendKeys(comp,Keys.ENTER).perform();

		conemailid.sendKeys(email);

		act.moveToElement(conposition).perform();
		conposition.sendKeys(position);
		consave.click();
	}


}

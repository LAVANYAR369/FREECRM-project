package com.crm.FreeCRMTest.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.FreeCRMTest.WebDriverUtility.WebDriverUtility;

public class Create_Contact_Test {
	 WebDriverUtility WD=new WebDriverUtility();

	WebDriver driver;
	public Create_Contact_Test(WebDriver driver)
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
@FindBy(xpath="//button[@class='ui linkedin button']")
private WebElement consave;

@FindBy(xpath="//i[@class='trash icon']")
private WebElement conDelete;
@FindBy(xpath="//button[@class='ui red button']")
private WebElement clickDeleteIcon;

public void PerformCreateContact(String fname,String lname,String comp,String email,String phone,String position)
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
}

public void performDeleteContact()
{
	conDelete.click();
	clickDeleteIcon.click();	
}

public void endToEndCreateContact(String fname,String lname,String email,String phone,String position)
{
	moveToContactBtn.click();
	//clickplusbtn.click();
	concreatebtn.click();
	confirstname.sendKeys(fname);
	conlastname.sendKeys(lname);
	
	Actions act=new Actions(driver);

	conemailid.sendKeys(email);

	act.moveToElement(conposition).perform();
	conposition.sendKeys(position);
	consave.click();
}

}












/*
 * @FindBy(xpath="//div[@name='category']") private WebElement concatname;
 * 
 * @FindBy(xpath="//span[text()='Contact']") private WebElement concatselect;
 * 
 * @FindBy(xpath="div[@name='status']") private WebElement constatus;
 * 
 * @FindBy(xpath="div[@name='address']") private WebElement conaddress;
 * 
 * @FindBy(xpath="//input[@placeholder='Number']") private WebElement conphone;
 * 
 * @FindBy(xpath="div[@name='position']") private WebElement conposition;
 * 
 * @FindBy(xpath="div[@name='department']") private WebElement condept;
 * 
 * @FindBy(xpath="div[@name='supervisor']") private WebElement consuper;
 * 
 * @FindBy(xpath="div[@name='assistant']") private WebElement conassis;
 * 
 * @FindBy(xpath="div[@name='referred_by']") private WebElement conrefer;
 * 
 * @FindBy(xpath="//span[text()='Referral']") private WebElement consource;
 */
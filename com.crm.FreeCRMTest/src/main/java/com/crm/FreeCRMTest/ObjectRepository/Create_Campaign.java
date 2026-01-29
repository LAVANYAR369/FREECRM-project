package com.crm.FreeCRMTest.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.FreeCRMTest.WebDriverUtility.WebDriverUtility;

public class Create_Campaign {
	WebDriver driver;
	public Create_Campaign(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//span[text()='Contacts']")
	private WebElement moveToContactBtn;

	@FindBy(xpath="//span[text()='Campaigns']")
	private WebElement campaigncreatebtn;
	@FindBy(xpath="//button[text()='Create']")
	private WebElement clickCreateCampaign;
	@FindBy(xpath="//input[@name='name']")
	private WebElement CreateCampName;
	@FindBy(xpath="//label[text()='Active']")
	private WebElement ClickActive;
	@FindBy(xpath="//button[@class='ui linkedin button']")
	private WebElement campsave;
	@FindBy(xpath="//div[@role='listbox']")
	private WebElement Settingicon;
	@FindBy(xpath="//span[text()='Products']")
	private WebElement Producticon;
	@FindBy(xpath="//button[@class='ui linkedin button']")
	private WebElement Productnewicon;
	@FindBy(xpath="(//input[@autocomplete='new-password'])[1]")
	private WebElement Productname;
	@FindBy(xpath="(//input[@autocomplete='new-password'])[2]")
	private WebElement ProductSKU;
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement ProductDescription;
	@FindBy(xpath="//input[@name='list_price']")
	private WebElement ProductListprice;
	@FindBy(xpath="//input[@name='wholesale_price']")
	private WebElement Productwholesaleprice;
	@FindBy(xpath="//input[@name='sale_price']")
	private WebElement ProductSalePrice;
	@FindBy(xpath="//input[@name='cost']")
	private WebElement ProductCost;
	@FindBy(xpath="//div[@class='ui selection dropdown']")
	private WebElement ProductCategory;
	@FindBy(xpath="//span[text()='Service']")
	private WebElement selectservice;
	@FindBy(xpath="//button[@class='ui linkedin button']")
	private WebElement SaveBtn;


	
	public void createCampaign(String cname)
	{
		Actions act=new Actions(driver);
		act.moveToElement(moveToContactBtn).perform();
		campaigncreatebtn.click();
		clickCreateCampaign.click();
		CreateCampName.sendKeys(cname);
		ClickActive.click();
		campsave.click();
		
	}
	public void createEndCampaign(String cname)
	{
		
		campaigncreatebtn.click();
		clickCreateCampaign.click();
		CreateCampName.sendKeys(cname);
		//ClickActive.click();
		campsave.click();
		
		
	}

}

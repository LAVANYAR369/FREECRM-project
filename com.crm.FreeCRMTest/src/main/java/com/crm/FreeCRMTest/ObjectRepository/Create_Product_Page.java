package com.crm.FreeCRMTest.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.FreeCRMTest.WebDriverUtility.WebDriverUtility;

public class Create_Product_Page {
	WebDriver driver;
	WebDriverUtility WU=new WebDriverUtility();
	public Create_Product_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
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
	public void CreateProduct(String name,String desc,String sku,String lprice,String wprice,String sprice,String cost,String cat)
	{
		//WU.waitForElementPresent(driver, Settingicon);
		Settingicon.click();
		Producticon.click();
		Productnewicon.click();
		Productname.sendKeys(name);
		ProductDescription.sendKeys(desc);
		ProductSKU.sendKeys(sku);
		ProductListprice.sendKeys(lprice);
		Productwholesaleprice.sendKeys(wprice);
		ProductSalePrice.sendKeys(sprice);
		ProductCost.sendKeys(cost);
		ProductCategory.sendKeys(cat);
		selectservice.click();
		SaveBtn.click();
		
	}
	
}

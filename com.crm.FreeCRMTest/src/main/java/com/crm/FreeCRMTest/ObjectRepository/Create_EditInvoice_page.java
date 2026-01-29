package com.crm.FreeCRMTest.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_EditInvoice_page {
	WebDriver driver;
	public Create_EditInvoice_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="(//i[@class='settings icon'])[1]")
	private WebElement Settingicon;
	@FindBy(xpath="//span[text()='Invoices']")
	private WebElement invoiceIcon;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	private WebElement createinvoiceIcon;
	@FindBy(xpath="(//i[@class='search icon'])[1]")
	private WebElement dealinvoiceIcon;
	@FindBy(xpath="(//div[@class='react-datepicker__input-container'])[1]")
	private WebElement issueDate;
	@FindBy(xpath="(//div[@class='react-datepicker__input-container'])[2]")
	private WebElement dueDate;
	@FindBy(xpath="(//div[@class='react-datepicker__input-container'])[2]")
	private WebElement paidAt;
	@FindBy(xpath="//div[text()='16']")
	private WebElement issueDate1;
	@FindBy(xpath="//div[text()='17']")
	private WebElement dueDate1;
	@FindBy(xpath="//div[text()='18']")
	private WebElement paidAt1;
	@FindBy(xpath="(//input[@aria-autocomplete='list'])[1]")
	private WebElement deal;
	@FindBy(xpath="(//input[@aria-autocomplete='list'])[2]")
	private WebElement company;
	@FindBy(xpath="(//input[@aria-autocomplete='list'])[3]")
	private WebElement contact;

	
	@FindBy(xpath="(//i[@class='edit icon'])[2]")
	private WebElement editInvoicBtn;
	@FindBy(xpath="//input[@name='description']")
	private WebElement editdescription;
	@FindBy(xpath="//i[@class='save outline icon']")
	private WebElement savebtn;
	
	public void performCreateInvoice(String deal)
	{
		Settingicon.click();
		invoiceIcon.click();
		createinvoiceIcon.click();
		dealinvoiceIcon.click();
		Actions act=new Actions(driver);
		act.sendKeys(deal,Keys.ENTER).perform();
		act.sendKeys(company,Keys.ENTER).perform();
		act.sendKeys(contact,Keys.ENTER).perform();
	}
	
	public void performInvoiceCreation(String desc)
	{
		Settingicon.click();
		invoiceIcon.click();
		editInvoicBtn.click();
		editdescription.sendKeys(desc);
		savebtn.click();
	}
}

package com.crm.FreeCRMTest.ObjectRepository;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.FreeCRMTest.JavaUtility.JavaUtility;
import com.crm.FreeCRMTest.WebDriverUtility.WebDriverUtility;

public class CreateInvoice {
	JavaUtility ju=new JavaUtility();
	WebDriverUtility wu=new WebDriverUtility();
	WebDriver driver;
	public CreateInvoice(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
		
	@FindBy(xpath="//div[@role='listbox']")
	private WebElement Settingicon;
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
	@FindBy(xpath="//button[@class='ui primary button']")
	private WebElement invoicesavebtn;
	public void generateInvoiceAndPro(String inDeal,String inComp,String inContact,String indesc,String inPrice,String inDisc)
	{
		Settingicon.click();
		invoicebtn.click();
		invoiceCreatebtn.click();
		deal.sendKeys(inDeal);

		company.sendKeys(inComp+ju.getRandomnum());
		contact.sendKeys(inContact+ju.getRandomnum());
		invoicedes.sendKeys(indesc);
		invoicePri.sendKeys(inPrice);
		invoiceDis.sendKeys(inDisc);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(invoicesavebtn)).click();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//invoicesavebtn.click();
		
	}
	public void generateInvoiceAndPro1(String inDeal,String inComp,String inContact,String indesc,String inPrice,String inDisc)
	{
	    Settingicon.click();
	    invoicebtn.click();
	    invoiceCreatebtn.click();

	    // Deal field
	    deal.sendKeys(inDeal);
	    deal.sendKeys(Keys.ENTER);

	    // Company field
	    company.sendKeys(inComp + ju.getRandomnum());
	    company.sendKeys(Keys.ENTER);

	    // Contact field
	    contact.sendKeys(inContact + ju.getRandomnum());
	    contact.sendKeys(Keys.ENTER);

	    // Other fields
	    invoicedes.sendKeys(indesc);
	    invoicePri.sendKeys(inPrice);
	    invoiceDis.sendKeys(inDisc);

	    // Scroll to save button to make it visible
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", invoicesavebtn);

	    // Wait until it is clickable
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(invoicesavebtn));

	    // JS click (most reliable for Free CRM)
	    js.executeScript("arguments[0].click();", invoicesavebtn);
	}


}

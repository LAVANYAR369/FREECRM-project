package com.crm.FreeCRMTest.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_Test {
	
	WebDriver driver;
	public Login_Page_Test(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement EmailBtn;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement PasswordBtn;
	
	@FindBy(xpath="//div[text()='Login']")
	private WebElement LoginBtn;
	
	public void PerformLogin(String url,String username,String password)
	{
		driver.get(url);
		EmailBtn.sendKeys(username);
		PasswordBtn.sendKeys(password);
		LoginBtn.click();
	}

}

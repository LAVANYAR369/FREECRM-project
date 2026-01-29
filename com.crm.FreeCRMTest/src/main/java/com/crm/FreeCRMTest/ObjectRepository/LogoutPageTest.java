package com.crm.FreeCRMTest.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPageTest {
	WebDriver driver;
	public LogoutPageTest(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@role='listbox']")
	private WebElement Settingicon;
	@FindBy(xpath="//span[text()='Log Out']")
	private WebElement logoutbtn;
	public void performLogout()
	{
		Settingicon.click();
		logoutbtn.click();
	}

}

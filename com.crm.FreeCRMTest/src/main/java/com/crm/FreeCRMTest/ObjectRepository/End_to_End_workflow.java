package com.crm.FreeCRMTest.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class End_to_End_workflow {
	WebDriver driver;
	public End_to_End_workflow(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[text()='ibm']")
	private WebElement moveToBtn;
	@FindBy(xpath="//button[@class='ui basic icon button custom-note-btn']")
	private WebElement addNotesbtn;
	@FindBy(xpath="//textarea[@rows='3']")
	private WebElement addNotes;
	@FindBy(xpath="//button[@class='ui green button']")
	private WebElement notesSave;
	@FindBy(xpath="(//i[@class='add icon'])[2]")
	private WebElement addContact;

	public void perfromEndToEnd(String notes)
	{
	Actions act=new Actions(driver);
	act.moveToElement(moveToBtn).perform();
	moveToBtn.click();
		addNotesbtn.click();
		addNotes.sendKeys(notes);
		notesSave.click();
		addContact.click();
		
	}
}

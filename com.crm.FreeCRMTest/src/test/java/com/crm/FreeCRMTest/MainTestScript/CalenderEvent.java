package com.crm.FreeCRMTest.MainTestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.Create_Case;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;
import com.crm.FreeCRMTest.ObjectRepository.createCalender;
@Listeners(com.crm.FreeCRMListenerUtility.ListenerUtility.class)
public class CalenderEvent extends BaseClass {
	@Test (groups="smokeTest")
	public void createCalenderwithEventAndNotesTest() throws Throwable
	{
	String url=FU.readDataFromPropertyFile("url");
	String username=FU.readDataFromPropertyFile("USERNAME");
	String password=FU.readDataFromPropertyFile("PASSWORD");
	
	Login_Page_Test lp=new Login_Page_Test(driver);
	lp.PerformLogin(url, username, password);
	
	String eveName=EU.getDataFromExcel("Freecrm", 25, 0);
	String addDescription=EU.getDataFromExcel("Freecrm", 25, 1);
	
	String caseName=EU.getDataFromExcel("Freecrm", 50,0);
	String cContact=EU.getDataFromExcel("Freecrm", 50,1);
	String cCompany=EU.getDataFromExcel("Freecrm", 50,2);
	String cDealNAme=EU.getDataFromExcel("Freecrm", 50,3);
	String cType=EU.getDataFromExcel("Freecrm", 50,4);
	String cIdentifier=EU.getDataFromExcel("Freecrm", 50,5);
	
	
	createCalender ccal=new createCalender(driver);
	ccal.createCalenderEvent(eveName, addDescription);
	Create_Case crce=new Create_Case(driver);
	crce.createCase(caseName, cContact, cCompany, cDealNAme, cType, cIdentifier);
	String expected=driver.findElement(By.xpath("//span[text()='Login Issue – Unable to Access Dashboard']")).getText();
	SoftAssert sof=new SoftAssert();
	sof.assertEquals(caseName,expected) ;
	sof.assertAll();
}

}

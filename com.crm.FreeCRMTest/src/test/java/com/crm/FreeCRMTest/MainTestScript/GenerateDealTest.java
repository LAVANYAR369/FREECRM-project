package com.crm.FreeCRMTest.MainTestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.Create_Deal_Test;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;
@Listeners(com.crm.FreeCRMListenerUtility.ListenerUtility.class)

public class GenerateDealTest extends BaseClass{
	@Test(groups="RegressionTest")
	public void generateDealTest() throws Throwable
	{
		String url=FU.readDataFromPropertyFile("url");
		String username=FU.readDataFromPropertyFile("USERNAME");
		String password=FU.readDataFromPropertyFile("PASSWORD");
		
		Login_Page_Test lp=new Login_Page_Test(driver);
		lp.PerformLogin(url, username, password);
		String dealNAme=EU.getDataFromExcel("Freecrm", 14,0);
		String dealCompany=EU.getDataFromExcel("Freecrm", 14,1);
		Create_Deal_Test cdt=new Create_Deal_Test(driver);
		cdt.createDealWithContact(dealNAme, dealCompany);
		String expected=driver.findElement(By.xpath("//span[text()='CRM Automation Contract']")).getText();
		SoftAssert sof=new SoftAssert();
		sof.assertEquals(dealNAme,expected) ;
		sof.assertAll();
		
		
	}

}

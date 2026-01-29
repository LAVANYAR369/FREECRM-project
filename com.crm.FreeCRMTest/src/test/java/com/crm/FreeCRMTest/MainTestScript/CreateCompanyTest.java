package com.crm.FreeCRMTest.MainTestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.Create_Company;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;
@Listeners(com.crm.FreeCRMListenerUtility.ListenerUtility.class)

public class CreateCompanyTest extends BaseClass {
	@Test(groups="smokeTest")
	public void createCompanyTest() throws Throwable
	{
		String url=FU.readDataFromPropertyFile("url");
		String username=FU.readDataFromPropertyFile("USERNAME");
		String password=FU.readDataFromPropertyFile("PASSWORD");
		
		Login_Page_Test lp=new Login_Page_Test(driver);
		lp.PerformLogin(url, username, password);
			
		String compname=EU.getDataFromExcel("Freecrm", 37, 0);
		String compWeb=EU.getDataFromExcel("Freecrm", 37, 1);
		String compAdd=EU.getDataFromExcel("Freecrm", 37, 2);
		String compphNo=EU.getDataFromExcel("Freecrm", 37, 3);
		String compEmp=EU.getDataFromExcel("Freecrm", 37, 4);
		String compIndustry =EU.getDataFromExcel("Freecrm", 37, 5);
		
		Create_Company crc=new Create_Company(driver);
		crc.createCompany(compname,compWeb,compAdd,compphNo,compEmp,compIndustry);
		 String Expec = driver.findElement(By.xpath("//p[text()='"+compname+"']")).getText();
		SoftAssert sof=new SoftAssert();
		sof.assertEquals(compname,Expec) ;
		sof.assertAll();
	
	}

}

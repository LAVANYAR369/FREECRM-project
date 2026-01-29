package com.crm.FreeCRMTest.MainTestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.Create_Case;
import com.crm.FreeCRMTest.ObjectRepository.Create_Company;
import com.crm.FreeCRMTest.ObjectRepository.Create_Task;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;
@Listeners(com.crm.FreeCRMListenerUtility.ListenerUtility.class)

public class CompanyToTaskFlowTest extends BaseClass {
	@Test(groups={"smokeTest","regressionTest"})
	public void companyToTaskFlowTest() throws Throwable
	{
		//login testscript data
		String url=FU.readDataFromPropertyFile("url");
		String username=FU.readDataFromPropertyFile("USERNAME");
		String password=FU.readDataFromPropertyFile("PASSWORD");
		//Testscriptdata-company creation
		String compname=EU.getDataFromExcel("Freecrm", 37, 0);
		String compWeb=EU.getDataFromExcel("Freecrm", 37, 1);
		String compAdd=EU.getDataFromExcel("Freecrm", 37, 2);
		String compphNo=EU.getDataFromExcel("Freecrm", 37, 3);
		String compEmp=EU.getDataFromExcel("Freecrm", 37, 4);
		String compIndustry =EU.getDataFromExcel("Freecrm", 37, 5);
		//Testscriptdata-contact creation
		String confname=EU.getDataFromExcel("Freecrm", 3, 0);
		String conlname=EU.getDataFromExcel("Freecrm", 3, 1);
		String concomp=EU.getDataFromExcel("Freecrm", 3, 2);
		String conemail=EU.getDataFromExcel("Freecrm", 3, 3);
		String conphoneno=EU.getDataFromExcel("Freecrm",3,4);
		String conposition=EU.getDataFromExcel("Freecrm", 3,5);
		//perform login operation
		Login_Page_Test lp=new Login_Page_Test(driver);
		lp.PerformLogin(url, username, password);
		//perform company and contact creation
		Create_Company crc=new Create_Company(driver);
		crc.createCompany(compname,compWeb,compAdd,compphNo,compEmp,compIndustry);
		System.out.println("company created succesfully");
		crc.PerformCreateContact(confname, conlname, concomp,  conemail,conphoneno, conposition);
		System.out.println("contact created and linked with the company");
		//perform contact creation	
		String taskNAme=EU.getDataFromExcel("Freecrm", 46,0);
		 String taskCompany=EU.getDataFromExcel("Freecrm", 46,2); 
		 String taskDeal=EU.getDataFromExcel("Freecrm", 46,3);
		 Create_Task ct=new Create_Task(driver); 
		 ct.createTask(taskNAme, taskCompany, taskDeal);
		 System.out.println("Task assigned to that particular contact");
		 
		 String caseName=EU.getDataFromExcel("Freecrm", 50,0);
			String cContact=EU.getDataFromExcel("Freecrm", 50,1);
			String cCompany=EU.getDataFromExcel("Freecrm", 50,2);
			String cDealName=EU.getDataFromExcel("Freecrm", 50,3);
			String cType=EU.getDataFromExcel("Freecrm", 50,4);
			String cIdentifier=EU.getDataFromExcel("Freecrm", 50,5);
			Thread.sleep(2000);
		 Create_Case cc=new Create_Case(driver);
		 cc.createCase(caseName, cContact, cCompany, cDealName,cType, cIdentifier);
		 System.out.println("case resolved by the contact");
		 String expected=driver.findElement(By.xpath("//span[text()='Login Issue – Unable to Access Dashboard']")).getText();
			SoftAssert sof=new SoftAssert();
			sof.assertEquals(caseName,expected) ;
			sof.assertAll();
			
	}



}

package com.crm.FreeCRMTest.TestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.util.Assert;
import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.CreateInvoice;
import com.crm.FreeCRMTest.ObjectRepository.Create_Campaign;
import com.crm.FreeCRMTest.ObjectRepository.Create_Case;
import com.crm.FreeCRMTest.ObjectRepository.Create_Company;
import com.crm.FreeCRMTest.ObjectRepository.Create_Contact_Test;
import com.crm.FreeCRMTest.ObjectRepository.Create_Deal_Test;
import com.crm.FreeCRMTest.ObjectRepository.Create_Event;
import com.crm.FreeCRMTest.ObjectRepository.Create_Product_Page;
import com.crm.FreeCRMTest.ObjectRepository.Create_Task;
import com.crm.FreeCRMTest.ObjectRepository.End_to_End_workflow;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;

public class Com_CRM_FreeCRM_MainclassTest extends BaseClass {
	@Test
	public void createContactToDealTest() throws Throwable
	{	//login testscript data
		String url=FU.readDataFromPropertyFile("url");
		String username=FU.readDataFromPropertyFile("USERNAME");
		String password=FU.readDataFromPropertyFile("PASSWORD");
		//perform login operation
		Login_Page_Test lp=new Login_Page_Test(driver);
		lp.PerformLogin(url, username, password);
		//TestScriptdata - product creation
		String proname=EU.getDataFromExcel("Freecrm", 9, 0);
		String prodesc=EU.getDataFromExcel("Freecrm", 9, 1);
		String proSKU=EU.getDataFromExcel("Freecrm", 9, 2);
		String prolprice=EU.getDataFromExcel("Freecrm", 9, 3);
		String prowprice=EU.getDataFromExcel("Freecrm", 9, 4);
		String prosprice=EU.getDataFromExcel("Freecrm", 9, 5);
		String procost=EU.getDataFromExcel("Freecrm", 9, 6);
		String procat=EU.getDataFromExcel("Freecrm", 9, 7);
		//Testscriptdata-contact creation
		String confname=EU.getDataFromExcel("Freecrm", 3, 0);
		String conlname=EU.getDataFromExcel("Freecrm", 3, 1);
		String concomp=EU.getDataFromExcel("Freecrm", 3, 2);
		String conemail=EU.getDataFromExcel("Freecrm", 3, 3);
		String conphoneno=EU.getDataFromExcel("Freecrm",3,4);
		String conposition=EU.getDataFromExcel("Freecrm", 3,5);
		//Testscriptdata-Deal creation
		String dealNAme=EU.getDataFromExcel("Freecrm", 14,0);
		String dealCompany=EU.getDataFromExcel("Freecrm", 14,1);
		//perform product creation
		Create_Product_Page cpp=new Create_Product_Page(driver);
		cpp.CreateProduct(proname, prodesc, proSKU, prolprice, prowprice, prosprice, procost, procat);
		//perfrom contact creation
		Thread.sleep(2000);
		Create_Contact_Test cct=new Create_Contact_Test(driver);
		cct.PerformCreateContact(confname, conlname, concomp, conemail, conphoneno, conposition);
		//perform Deal creation and save everything
		Create_Deal_Test cdt=new Create_Deal_Test(driver);
		cdt.createDealWithContact(dealNAme,dealCompany);

	}

		@Test
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
			crc.PerformCreateContact(confname, conlname, concomp,  conemail,conphoneno, conposition);
			//perform contact creation	
			String taskNAme=EU.getDataFromExcel("Freecrm", 46,0);
			 String taskCompany=EU.getDataFromExcel("Freecrm", 46,2); 
			 String taskDeal=EU.getDataFromExcel("Freecrm", 46,3);
			 Create_Task ct=new Create_Task(driver); 
			 ct.createTask(taskNAme, taskCompany, taskDeal);
		}
	
	
	
	
	@Test
	public void createDealWithcontactTest() throws Throwable
	{
		String url=FU.readDataFromPropertyFile("url");
		String username=FU.readDataFromPropertyFile("USERNAME");
		String password=FU.readDataFromPropertyFile("PASSWORD");
		String dealNAme=EU.getDataFromExcel("Freecrm", 14,0);
		String dealAmount=EU.getDataFromExcel("Freecrm", 14,2);
		String dealCompany=EU.getDataFromExcel("Freecrm", 14,1);
		Login_Page_Test lp=new Login_Page_Test(driver);
		lp.PerformLogin(url, username, password);
		//Create_Deal_Test cdt=new Create_Deal_Test(driver);
		//cdt.createDeal(dealNAme,dealCompany,dealAmount);
	//cdt.selectContact(dealNAme);
		//cdt.createDealWithContact(dealNAme);

//	 String taskNAme=EU.getDataFromExcel("Freecrm", 46,0);
//	 String taskCompany=EU.getDataFromExcel("Freecrm", 46,2); 
//	 Create_Task ct=new Create_Task(driver); 
	// ct.createTask(taskNAme, taskCompany);
		String campNAme=EU.getDataFromExcel("Freecrm", 46,0);
		Create_Campaign cca=new Create_Campaign(driver);
		cca.createCampaign(campNAme);

	}

	@Test
	public void createEneToEndTest() throws Throwable
	{
		String url=FU.readDataFromPropertyFile("url");
		String username=FU.readDataFromPropertyFile("USERNAME");
		String password=FU.readDataFromPropertyFile("PASSWORD");
		Login_Page_Test lp=new Login_Page_Test(driver);
		lp.PerformLogin(url, username, password);
		
		String dealNAme=EU.getDataFromExcel("Freecrm", 14,0);
		String dealAmount=EU.getDataFromExcel("Freecrm", 14,2);
		String dealCompany=EU.getDataFromExcel("Freecrm", 14,1);
		
		String caseNAme=EU.getDataFromExcel("Freecrm", 50,0);
		String cContact=EU.getDataFromExcel("Freecrm", 50,1);
		String cCompany=EU.getDataFromExcel("Freecrm", 50,2);
		String cDealNAme=EU.getDataFromExcel("Freecrm", 50,3);
		String cType=EU.getDataFromExcel("Freecrm", 50,4);
		String cIdentifier=EU.getDataFromExcel("Freecrm", 50,5);
		
		Create_Case crce=new Create_Case(driver);
		crce.createCase(caseNAme, cContact, cCompany, cDealNAme, cType, cIdentifier);
	}
	
	@Test
	public void EneToEndTest() throws Throwable
	{
		String url=FU.readDataFromPropertyFile("url");
		String username=FU.readDataFromPropertyFile("USERNAME");
		String password=FU.readDataFromPropertyFile("PASSWORD");
		Login_Page_Test lp=new Login_Page_Test(driver);
		lp.PerformLogin(url, username, password);
		String addNotes=EU.getDataFromExcel("endToEnd", 1,1);

		End_to_End_workflow eew=new End_to_End_workflow(driver);
		eew.perfromEndToEnd(addNotes);
		
		String confname=EU.getDataFromExcel("Freecrm", 3, 0);
		String conlname=EU.getDataFromExcel("Freecrm", 3, 1);
		String concomp=EU.getDataFromExcel("Freecrm", 3, 2);
		String conemail=EU.getDataFromExcel("Freecrm", 3, 3);
		String conphoneno=EU.getDataFromExcel("Freecrm",3,4);
		String conposition=EU.getDataFromExcel("Freecrm", 3,5);
		
		String eventName=EU.getDataFromExcel("endToEnd", 2,1);
		Create_Contact_Test cct=new Create_Contact_Test(driver);
		cct.endToEndCreateContact(confname, conlname,  conemail, conphoneno, conposition);
		Create_Event ce=new Create_Event(driver);
		ce.createEvent(eventName);
		
		String campNAme=EU.getDataFromExcel("Freecrm", 46,0);
		
		Create_Campaign cca=new Create_Campaign(driver);
		cca.createEndCampaign(campNAme);
		
	
	}
	@Test
	public void editInvoiceTest() throws Throwable {

	    String url = FU.readDataFromPropertyFile("url");
	    String username = FU.readDataFromPropertyFile("USERNAME");
	    String password = FU.readDataFromPropertyFile("PASSWORD");

	    Login_Page_Test lp = new Login_Page_Test(driver);
	    lp.PerformLogin(url, username, password);

	    // Expected values from Excel
	    String invoicedesc = EU.getDataFromExcel("Freecrm", 17, 0);
	    String invoicedeal = EU.getDataFromExcel("Freecrm", 17, 1);

	    // New invoice values for edit
	    String inDeal = EU.getDataFromExcel("Freecrm", 29, 0);
	    String inCompany = EU.getDataFromExcel("Freecrm", 29, 1);
	    String inContact = EU.getDataFromExcel("Freecrm", 29, 2);
	    String inDescri = EU.getDataFromExcel("Freecrm", 29, 3);
	    String inPrice = EU.getDataFromExcel("Freecrm",29, 4);
	    String inDiscount = EU.getDataFromExcel("Freecrm", 29, 5);

	    // Create invoice
	    CreateInvoice ci = new CreateInvoice(driver);
	    ci.generateInvoiceAndPro1(inDeal, inCompany, inContact, inDescri, inPrice, inDiscount);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

	    // Universal locator
	    WebElement descElement = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//td[text()='"+inDescri+"']") ) );

	    String actual = descElement.getText();
	    
	    org.testng.Assert.assertEquals(actual, inDescri);


	}

}

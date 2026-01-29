package com.crm.FreeCRMTest.MainTestScript;

import org.openqa.selenium.By;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.CreateInvoice;
import com.crm.FreeCRMTest.ObjectRepository.Create_Company;
import com.crm.FreeCRMTest.ObjectRepository.Create_Contact_Test;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;

public class SmokeTest extends BaseClass{
	@Test
	public void editInvoiceTest() throws Throwable
	{
	String url=FU.readDataFromPropertyFile("url");
	String username=FU.readDataFromPropertyFile("USERNAME");
	String password=FU.readDataFromPropertyFile("PASSWORD");
	
	Login_Page_Test lp=new Login_Page_Test(driver);
	lp.PerformLogin(url, username, password);
		
	String invoicedesc=EU.getDataFromExcel("Freecrm", 17, 0);
	String invoicedeal=EU.getDataFromExcel("Freecrm", 17, 1);
	
	String inDeal=EU.getDataFromExcel("Freecrm", 29, 0);
	String inCompany=EU.getDataFromExcel("Freecrm", 29, 1);
	String inContact=EU.getDataFromExcel("Freecrm", 29, 2);
	String inDescri=EU.getDataFromExcel("Freecrm", 29, 3);
	String inPrice=EU.getDataFromExcel("Freecrm",29, 4);
	String inDiscount=EU.getDataFromExcel("Freecrm", 29, 5);

	CreateInvoice ci=new CreateInvoice(driver);
	ci.generateInvoiceAndPro1(inDeal, inCompany, inContact, inDescri, inPrice, inDiscount);
	
	  String invoiceEdit=driver.findElement(By.xpath("//td[contains(text(),'infosys263')]")).getText();
			  SoftAssert soft=new SoftAssert(); 
	  soft.assertEquals(inCompany,invoiceEdit, "pass");
	  soft.assertAll();
	
	}
	
	@Test
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
	@Test
	public void deleteContactTest() throws Throwable
	{
		String url=FU.readDataFromPropertyFile("url");
		String username=FU.readDataFromPropertyFile("USERNAME");
		String password=FU.readDataFromPropertyFile("PASSWORD");
		
		Login_Page_Test lp=new Login_Page_Test(driver);
		lp.PerformLogin(url, username, password);
		String confname=EU.getDataFromExcel("Freecrm", 3, 0);
		String conlname=EU.getDataFromExcel("Freecrm", 3, 1);
		String concomp=EU.getDataFromExcel("Freecrm", 3, 2);
		String conemail=EU.getDataFromExcel("Freecrm", 3, 3);
		String conphoneno=EU.getDataFromExcel("Freecrm",3,4);
		String conposition=EU.getDataFromExcel("Freecrm", 3,5);
		Create_Contact_Test cct=new Create_Contact_Test(driver);
		cct.PerformCreateContact(confname, conlname, concomp, conemail, conphoneno, conposition);
		String text=driver.findElement(By.xpath("//div[text()='"+conemail+"']")).getText();
		System.out.println(text);
		SoftAssert sof=new SoftAssert();
		sof.assertEquals(conemail,text) ;
		cct.performDeleteContact();
		sof.assertAll();
		
	}
	
	}
	

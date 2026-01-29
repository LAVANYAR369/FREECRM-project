package com.crm.FreeCRMTest.TestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.CreateInvoice;
import com.crm.FreeCRMTest.ObjectRepository.Create_Contact_Test;
import com.crm.FreeCRMTest.ObjectRepository.Create_Deal_Test;
import com.crm.FreeCRMTest.ObjectRepository.EndToEnd1;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;

public class ContactDealInvoiceTest extends BaseClass {
	@Test
	public void performConDealInTest() throws Throwable
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
		
		String dealNAme=EU.getDataFromExcel("Freecrm", 14,0);
		String dealCompany=EU.getDataFromExcel("Freecrm", 14,1);
		String inDeal=EU.getDataFromExcel("Freecrm", 29, 0);
		String inCompany=EU.getDataFromExcel("Freecrm", 29, 1);
		String inContact=EU.getDataFromExcel("Freecrm", 29, 2);
		String inDescri=EU.getDataFromExcel("Freecrm", 29, 3);
		String inPrice=EU.getDataFromExcel("Freecrm",29, 4);
		String inDiscount=EU.getDataFromExcel("Freecrm", 29, 5);

		
		
		EndToEnd1 ete=new EndToEnd1(driver);
		ete.PerformCreateContact(confname, conlname, conlname, conemail, conphoneno, conposition,dealNAme,inDeal,inCompany,inContact,inDescri,inPrice,inDiscount);
		//ete.createDealWithContact(dealNAme, concomp);
		//cct.PerformCreateContact(confname, conlname, concomp, conemail, conphoneno, conposition);
		
//		Create_Deal_Test cdt=new Create_Deal_Test(driver);
//		cdt.createDealWithContact(dealNAme,dealCompany);
//		
	//CreateInvoice ci=new CreateInvoice(driver);
		//ci.generateInvoiceAndPro1(inDeal, inCompany, inContact, inDescri, inPrice, inDiscount);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		WebElement invoice = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td[.//text()[normalize-space()='infosys']])[1]"))
		);

		String invoiceEdit = invoice.getText();

		// Assertion
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(invoiceEdit.contains(inCompany), "Invoice not updated!");
		soft.assertAll();

	}

}

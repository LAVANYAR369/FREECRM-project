package com.crm.FreeCRMTest.TestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.CreateInvoice;
import com.crm.FreeCRMTest.ObjectRepository.Create_Case;
import com.crm.FreeCRMTest.ObjectRepository.Create_Company;
import com.crm.FreeCRMTest.ObjectRepository.Create_Deal_Test;
import com.crm.FreeCRMTest.ObjectRepository.Create_EditInvoice_page;
import com.crm.FreeCRMTest.ObjectRepository.Create_Product_Page;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;
import com.crm.FreeCRMTest.ObjectRepository.SearchContactPage;
import com.crm.FreeCRMTest.ObjectRepository.createCalender;

public class IntegrationTest extends BaseClass {
	@Test
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
	@Test
	public void generateInvoiceWithProductTest() throws Throwable
	{
		String url=FU.readDataFromPropertyFile("url");
		String username=FU.readDataFromPropertyFile("USERNAME");
		String password=FU.readDataFromPropertyFile("PASSWORD");
		
		Login_Page_Test lp=new Login_Page_Test(driver);
		lp.PerformLogin(url, username, password);
		
		String proname=EU.getDataFromExcel("Freecrm", 9, 0);
		String prodesc=EU.getDataFromExcel("Freecrm", 9, 1);
		String proSKU=EU.getDataFromExcel("Freecrm", 9, 2);
		String prolprice=EU.getDataFromExcel("Freecrm", 9, 3);
		String prowprice=EU.getDataFromExcel("Freecrm", 9, 4);
		String prosprice=EU.getDataFromExcel("Freecrm", 9, 5);
		String procost=EU.getDataFromExcel("Freecrm", 9, 6);
		String procat=EU.getDataFromExcel("Freecrm", 9, 7);
		
		String compname=EU.getDataFromExcel("Freecrm", 37, 0);
		String compWeb=EU.getDataFromExcel("Freecrm", 37, 1);
		String compAdd=EU.getDataFromExcel("Freecrm", 37, 2);
		String compphNo=EU.getDataFromExcel("Freecrm", 37, 3);
		String compEmp=EU.getDataFromExcel("Freecrm", 37, 4);
		String compIndustry =EU.getDataFromExcel("Freecrm", 37, 5);
		
		Create_Company crc=new Create_Company(driver);
		crc.createCompany(compname,compWeb,compAdd,compphNo,compEmp,compIndustry);
		Thread.sleep(2000);
		Create_Product_Page cpp=new Create_Product_Page(driver);
		cpp.CreateProduct(proname, prodesc, proSKU, prolprice, prowprice, prosprice, procost, procat);
		Thread.sleep(2000);
		String inDeal=EU.getDataFromExcel("Freecrm", 29, 0);
		String inCompany=EU.getDataFromExcel("Freecrm", 29, 1);
		String inContact=EU.getDataFromExcel("Freecrm", 29, 2);
		String inDescri=EU.getDataFromExcel("Freecrm", 29, 3);
		String inPrice=EU.getDataFromExcel("Freecrm",29, 4);
		String inDiscount=EU.getDataFromExcel("Freecrm", 29, 5);

		CreateInvoice ci=new CreateInvoice(driver);
		ci.generateInvoiceAndPro1(inDeal, inCompany, inContact, inDescri, inPrice, inDiscount);
		
	}
	
	@Test
	public void searchContactAddTaskTest() throws Throwable
	{
		String url=FU.readDataFromPropertyFile("url");
		String username=FU.readDataFromPropertyFile("USERNAME");
		String password=FU.readDataFromPropertyFile("PASSWORD");
		
		Login_Page_Test lp=new Login_Page_Test(driver);
		lp.PerformLogin(url, username, password);
		
		String searchName=EU.getDataFromExcel("Freecrm",33, 0);
		String searchTitle=EU.getDataFromExcel("Freecrm", 33, 1);
		
		SearchContactPage scp=new SearchContactPage(driver);
		scp.searchConTask(searchName, searchTitle);
		
		String expected=driver.findElement(By.xpath("//p[text()='product purchase']")).getText();
	SoftAssert sof=new SoftAssert();
		sof.assertEquals(searchTitle,expected);
		sof.assertAll();

	}
	
}

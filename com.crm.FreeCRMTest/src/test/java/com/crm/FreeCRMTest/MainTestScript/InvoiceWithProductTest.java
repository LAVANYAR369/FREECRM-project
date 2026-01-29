package com.crm.FreeCRMTest.MainTestScript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.CreateInvoice;
import com.crm.FreeCRMTest.ObjectRepository.Create_Company;
import com.crm.FreeCRMTest.ObjectRepository.Create_Product_Page;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;
@Listeners(com.crm.FreeCRMListenerUtility.ListenerUtility.class)

public class InvoiceWithProductTest extends BaseClass {
	@Test(groups={"smokeTest","regressionTest"})
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
	

}

package com.crm.FreeCRMTest.MainTestScript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.Create_Contact_Test;
import com.crm.FreeCRMTest.ObjectRepository.Create_Deal_Test;
import com.crm.FreeCRMTest.ObjectRepository.Create_Product_Page;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;
@Listeners(com.crm.FreeCRMListenerUtility.ListenerUtility.class)

public class CreateContactToDeal extends BaseClass{
	@Test (groups={"smokeTest","regressionTest"})
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
		System.out.println("product created successfully");
		//WebElement waitForElement=driver.findElement(By.xpath("//div[@role='listbox']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']"))).click();

		Create_Contact_Test cct=new Create_Contact_Test(driver);
		cct.PerformCreateContact(confname, conlname, concomp, conemail, conphoneno, conposition);
		System.out.println("product linked with the contact");
		//perform Deal creation and save everything
		Thread.sleep(2000);
		Create_Deal_Test cdt=new Create_Deal_Test(driver);
		cdt.createDealWithContact(dealNAme,dealCompany);
		System.out.println("deal created with the contact");
		String expected=driver.findElement(By.xpath("//span[text()='CRM Automation Contract']")).getText();
		SoftAssert sof=new SoftAssert();
		sof.assertEquals(dealNAme,expected) ;
		sof.assertAll();

	}
	}

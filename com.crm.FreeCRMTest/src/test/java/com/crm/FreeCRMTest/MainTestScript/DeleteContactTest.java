package com.crm.FreeCRMTest.MainTestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.Create_Contact_Test;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;
@Listeners(com.crm.FreeCRMListenerUtility.ListenerUtility.class)

public class DeleteContactTest extends BaseClass {
	@Test(groups="smokeTest")
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
		//sof.assertAll();
		
	}

}

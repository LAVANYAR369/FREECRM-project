package com.crm.FreeCRMTest.MainTestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.Create_Campaign;
import com.crm.FreeCRMTest.ObjectRepository.Create_Contact_Test;
import com.crm.FreeCRMTest.ObjectRepository.Create_Event;
import com.crm.FreeCRMTest.ObjectRepository.End_to_End_workflow;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;
@Listeners(com.crm.FreeCRMListenerUtility.ListenerUtility.class)

public class EndToEndTestFlow extends BaseClass {
	@Test(groups={"smokeTest","regressionTest"})
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
		
		String campNAme=EU.getDataFromExcel("endToEnd", 2,1);
		
		Create_Campaign cca=new Create_Campaign(driver);
		//cca.createCampaign(campNAme);
		String expected=driver.findElement(By.xpath("//span[text()='New Meeting Arranged']")).getText();
		SoftAssert sof=new SoftAssert();
		sof.assertEquals(campNAme,expected) ;
		sof.assertAll();
	
	}

}

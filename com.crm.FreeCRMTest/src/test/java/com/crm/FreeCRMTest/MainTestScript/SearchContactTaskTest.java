package com.crm.FreeCRMTest.MainTestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.FreeCRMTest.Baseclass.BaseClass;
import com.crm.FreeCRMTest.ObjectRepository.Login_Page_Test;
import com.crm.FreeCRMTest.ObjectRepository.SearchContactPage;
@Listeners(com.crm.FreeCRMListenerUtility.ListenerUtility.class)

public class SearchContactTaskTest extends BaseClass {
	@Test(groups={"smokeTest","regressionTest"})
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

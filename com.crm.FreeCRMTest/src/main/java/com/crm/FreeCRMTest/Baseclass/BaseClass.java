package com.crm.FreeCRMTest.Baseclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.crm.FreeCRMTest.DatabaseUtility.DatabaseUtility;
import com.crm.FreeCRMTest.ExcelUtility.ExcelUtility;
import com.crm.FreeCRMTest.FileUtility.FileUtility;
import com.crm.FreeCRMTest.JavaUtility.JavaUtility;
import com.crm.FreeCRMTest.ObjectRepository.LogoutPageTest;
import com.crm.FreeCRMTest.WebDriverUtility.WebDriverUtility;

public class BaseClass {
	public DatabaseUtility DB=new DatabaseUtility();
	public ExcelUtility EU=new ExcelUtility();
	public FileUtility FU=new FileUtility();
	public JavaUtility JU=new JavaUtility();
	public WebDriverUtility WD=new WebDriverUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver;



	
	@BeforeSuite (groups= {"smokeTest","regressionTest"})
	public void config()
	{
		System.out.println("===Connect to DB, and Report Configuration===");

	}
	@BeforeClass  (groups= {"smokeTest","regressionTest"})
	public void configBC() throws Throwable
	{
		System.out.println("launch the browser");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disabled-notifications");
		String Browser = FU.readDataFromPropertyFile("browser");
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver(options);
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();

		} else {
			driver = new ChromeDriver();
		}
		//driver = new ChromeDriver();
		sdriver = driver;   


		driver.manage().window().maximize();
		WD.waitForPageToLoad(driver);

	}
	@BeforeMethod (groups= {"smokeTest","regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("login to application");
		String url = FU.readDataFromPropertyFile("url");
		String Username = FU.readDataFromPropertyFile("USERNAME");
		String Password = FU.readDataFromPropertyFile("PASSWORD");
		
	}
	@AfterMethod (groups= {"smokeTest","regressionTest"})
	public void configAM() throws InterruptedException
	{
		System.out.println("perform logout operation");			
	LogoutPageTest lpt=new LogoutPageTest(driver);
	lpt.performLogout();
	
	}
	@AfterClass (groups= {"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("To perform close browser");
		driver.quit();
	}

	@AfterSuite (groups= {"smokeTest","regressionTest"})
	public void configAS() {
		System.out.println("To perform close database connection and Reportbackup");

	}


	}



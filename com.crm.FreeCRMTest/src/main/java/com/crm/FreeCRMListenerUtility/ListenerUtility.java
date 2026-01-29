package com.crm.FreeCRMListenerUtility;

import java.time.LocalDateTime;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.crm.FreeCRMTest.Baseclass.BaseClass;

public class ListenerUtility implements ITestListener, ISuiteListener {

    public ExtentReports report;
    public static ExtentTest test;
    public WebDriver driver = null;

    @Override
    public void onStart(ISuite suite) {

        String timedate = LocalDateTime.now().toString().replace(":", "-");

        ExtentSparkReporter spark = new ExtentSparkReporter("./Advencereport/report--" + timedate + ".html");
        spark.config().setDocumentTitle("CRM Test Suite");
        spark.config().setReportName("CRM Automation Report");
        spark.config().setTheme(Theme.DARK);

        report = new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("OS", "Windows-11");
    }

    @Override
    public void onFinish(ISuite suite) {
        report.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = report.createTest(result.getMethod().getMethodName());
        test.log(Status.INFO, result.getMethod().getMethodName() + " ===> Test Started ===>");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, result.getMethod().getMethodName() + " ===> Test Passed ===>");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        driver = BaseClass.sdriver;  // Ensure WebDriver is available

        if (driver != null) {

            String testname = result.getMethod().getMethodName();
            String timedate = LocalDateTime.now().toString().replace(":", "-");

            TakesScreenshot ts = (TakesScreenshot) driver;
            String filepath = ts.getScreenshotAs(OutputType.BASE64);

            test.addScreenCaptureFromBase64String(filepath, "Failure Screenshot");

            // Log full exception with stacktrace
            test.fail(result.getThrowable());
            test.log(Status.FAIL, testname + " ===> Test Failed <===");
        } else {
            test.log(Status.FAIL, "Driver is NULL - Screenshot cannot be captured.");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, result.getMethod().getMethodName() + " ===> Test Skipped ===>");
    }

    @Override
    public void onStart(ITestContext context) { }

    @Override
    public void onFinish(ITestContext context) { }

}

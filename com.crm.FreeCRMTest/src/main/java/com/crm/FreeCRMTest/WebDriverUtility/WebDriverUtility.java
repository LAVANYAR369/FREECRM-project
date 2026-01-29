package com.crm.FreeCRMTest.WebDriverUtility;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchNewBrowserTab(WebDriver driver, String partialURL) {
	    Set<String> windows = driver.getWindowHandles();
	    for (String win : windows) {
	        driver.switchTo().window(win);
	        if (driver.getCurrentUrl().contains(partialURL)) {
	            break;
	        }
	    }
	}


	public String getParentWindowID(WebDriver driver) {
	    return driver.getWindowHandle();
	}

	public void switchToParentWindow(WebDriver driver, String parentID) {
	    driver.switchTo().window(parentID);
	}

		public String switchToTabOnTitle(WebDriver driver, String partialTitle)
		{
			Set<String>set=driver.getWindowHandles();
			Iterator<String>it=set.iterator();
			while(it.hasNext())
			{
				String windowID=it.next();
				driver.switchTo().window(windowID);
				String actTitle=driver.getTitle();
				if(actTitle.contains(partialTitle))
				{
					break;
				}
			}
			return partialTitle;
			
	
		}
		public void switchToFrame(WebDriver driver,int index)
		{
			driver.switchTo().frame(index);
		}
		public void switchToFrame(WebDriver driver,String nameID)
		{
			driver.switchTo().frame(nameID);
		}
		public void switchToFrame(WebDriver driver,WebElement element)
		{
			driver.switchTo().frame(element);
		}
		public void switchToAlertAndAccept(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		public void switchToAlertAndDismiss(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		public void switchToAlertAndGetText(WebDriver driver)
		{
			driver.switchTo().alert().getText();
		}
		public void select(WebElement element, String text)
		{
			Select s=new Select(element);
			s.selectByVisibleText(text);
		}
		public void select(WebElement element, int index)
		{
			Select s=new Select(element);
			s.selectByIndex(index);
		}
		public void selectByIndex(WebElement element,int index)
		{
			Select s=new Select(element);
			s.selectByIndex(index);
		}
		public void selectByValue(WebElement element, String text)
		{
			Select s=new Select(element);
			s.selectByValue(text);
		}
		public void deSelectByIndex(WebElement element, int index)
		{
			Select s=new Select(element);
			s.deselectByIndex(index);
		}
		public void deSelectByValue(WebElement element, String text)
		{
			Select s=new Select(element);
			s.deselectByValue(text);
		}
		public void deSelectByVisibleText(WebElement element, String text)
		{
			Select s=new Select(element);
			s.deselectByVisibleText(text);
		}
		public void deSelectByContainsText(WebElement element, String text)
		{
			Select s=new Select(element);
			s.deselectByVisibleText(text);
		}
		public void deSelectByAll(WebElement element, String text)
		{
			Select s=new Select(element);
			s.deselectAll();
		}
		public void moveToElement(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.moveToElement(element).perform();
		}
		public void doubleClick(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.doubleClick(element).perform();
		}
		public void clickAndHold(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.clickAndHold(element).perform();
		}
		public void dragAndDrop(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.dragAndDrop(element, element).perform();
		}
		public void dragAndDropBy(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.dragAndDropBy(element, 0, 0).perform();
		}
		public void ScrollToElement(WebDriver driver,WebElement element)
		{
			Actions act=new Actions(driver);
			act.scrollToElement(element).perform();
		}
		
		public void Takesscreenshot(WebDriver driver,String fileName) throws Throwable
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src= ts.getScreenshotAs(OutputType.FILE);
			File dest=new File("./screenshot/filename.png");
			FileUtils.copyFile(src, dest);
			
		}

}

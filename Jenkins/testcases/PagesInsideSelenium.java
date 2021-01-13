package com.Guru99.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.Guru99.genericLib.Base;
import com.Guru99.genericLib.FileLib;
import com.Guru99.pagerepository.Home;
import com.Guru99.pagerepository.SeleniumDD;


@Listeners(com.Guru99.genericLib.ListenerImp.class)
public class PagesInsideSelenium extends Base
{
	
	FileLib lib = new FileLib();
	Home h;
	SeleniumDD sd;
	
	@Test
	public void loginPageDisplayVerification() throws InterruptedException
	{
		h = PageFactory.initElements(driver, Home.class);
		sd = PageFactory.initElements(driver, SeleniumDD.class);
		
		h.getSeleniumDD().click();
		Reporter.log("Clicked on the Selenium dropdown", true);
		Thread.sleep(2000);
		
		sd.getLoginpagelink().click();
		Reporter.log("Clicked on the login Button", true);
		
		Thread.sleep(10000);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Reporter.log("url get copied", true);
		
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(url, lib.getDataFromPrpoertyFile("LoginPageUrl"));
		
		Reporter.log("url's Verified", true);
		
		sft.assertAll();
		
	}
		
}





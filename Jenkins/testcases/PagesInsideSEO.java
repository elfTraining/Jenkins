package com.Guru99.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.Guru99.genericLib.Base;
import com.Guru99.genericLib.FileLib;
import com.Guru99.pagerepository.Home;
import com.Guru99.pagerepository.SeoDD;


@Listeners(com.Guru99.genericLib.ListenerImp.class)
public class PagesInsideSEO extends Base
{
	
	FileLib lib = new FileLib();
	Home h;
	SeoDD s;
	
	@Test
	public void logoutPageVerification() throws InterruptedException
	{
		h = PageFactory.initElements(driver, Home.class);
		s = PageFactory.initElements(driver, SeoDD.class);
		
		for (int i = 0; i < 6; i++) 
		{
			h.getSeoDD().click();
			Reporter.log("Clicked on the Seo dropdown", true);
			Thread.sleep(2000);
			
			SoftAssert sft = new SoftAssert();
			
			if (i==0) 
			{
				s.getPage1link().click();
				Reporter.log("Clicked on the Page1 link", true);
				Thread.sleep(10000);
				
				String url1 = driver.getCurrentUrl();
				Reporter.log("url get copied", true);
				sft.assertEquals(url1, lib.getDataFromPrpoertyFile("Page1Url"));
			}
			
			else if (i==1) 
			{
				s.getPage2link().click();
				Reporter.log("Clicked on the Page2 link", true);
				Thread.sleep(10000);
				
				String url2 = driver.getCurrentUrl();
				Reporter.log("url get copied", true);
				sft.assertEquals(url2, lib.getDataFromPrpoertyFile("Page2Url"));
			}
			
			else if (i==2) 
			{
				s.getPage3link().click();
				Reporter.log("Clicked on the Page3 link", true);
				Thread.sleep(10000);
				
				String url3 = driver.getCurrentUrl();
				Reporter.log("url get copied", true);
				sft.assertEquals(url3, lib.getDataFromPrpoertyFile("Page3Url"));
			}
			
			else if (i==3) 
			{
				s.getPage4link().click();
				Reporter.log("Clicked on the Page4 link", true);
				Thread.sleep(10000);
				
				String url4 = driver.getCurrentUrl();
				Reporter.log("url get copied", true);
				sft.assertEquals(url4, lib.getDataFromPrpoertyFile("Page4Url"));
			}
			
			else if (i==4) 
			{
				s.getPage5link().click();
				Reporter.log("Clicked on the Page5 link", true);
				Thread.sleep(10000);
				
				String url5 = driver.getCurrentUrl();
				Reporter.log("url get copied", true);
				sft.assertEquals(url5, lib.getDataFromPrpoertyFile("Page5Url"));
			}
			
			else
			{
				s.getPage6link().click();
				Reporter.log("Clicked on the Page6 link", true);
				Thread.sleep(10000);
				
				String url6 = driver.getCurrentUrl();
				Reporter.log("url get copied", true);
				sft.assertEquals(url6, lib.getDataFromPrpoertyFile("Page6Url"));
			}
			
			Reporter.log("url's Verified", true);
			
			sft.assertAll();
		}
			
	}
		
}





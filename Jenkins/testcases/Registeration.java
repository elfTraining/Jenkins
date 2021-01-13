package com.Guru99.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.Guru99.genericLib.Base;
import com.Guru99.genericLib.FileLib;
import com.Guru99.pagerepository.Home;
import com.Guru99.pagerepository.RegistrationPage;


@Listeners(com.Guru99.genericLib.ListenerImp.class)
public class Registeration extends Base
{
	
	FileLib lib = new FileLib();
	Home h;
	RegistrationPage rp;
	
	@Test
	public void registrationsuccessfullVerification() throws InterruptedException
	{
		h = PageFactory.initElements(driver, Home.class);
		rp = PageFactory.initElements(driver, RegistrationPage.class);
		
		h.getRegisterlink().click();
		Reporter.log("Clicked on the Registration link", true);
		Thread.sleep(3000);
		
		rp.getFirstName().sendKeys(lib.getDataFromPrpoertyFile("FirstName"));
		Reporter.log("Entered First Name", true);
				
		rp.getLastName().sendKeys(lib.getDataFromPrpoertyFile("LatName"));
		Reporter.log("Entered Last Name", true);
		
		rp.getPhone().sendKeys(lib.getDataFromPrpoertyFile("Phone"));
		Reporter.log("Entered Phone number", true);
		
		rp.getEmailId().sendKeys(lib.getDataFromPrpoertyFile("Email"));
		Reporter.log("Entered Email address", true);
		
		rp.getAddress1().sendKeys(lib.getDataFromPrpoertyFile("Adress"));
		Reporter.log("Entered Addess", true);
		
		rp.getCity().sendKeys(lib.getDataFromPrpoertyFile("City"));
		Reporter.log("Entered City Name", true);
		
		rp.getState().sendKeys(lib.getDataFromPrpoertyFile("State"));
		Reporter.log("Entered State name", true);
		
		rp.getCountryDD().click();
		Reporter.log("Clicked on the Country dropdown", true);
		
		rp.SelectcountryName(lib.getSpecifiedDataFromExcelFile("Data", 1, 12));
		Reporter.log("Selected the Country name the Dropdown", true);
		
		rp.getPostalcode().sendKeys(lib.getDataFromPrpoertyFile("PostalCode"));
		Reporter.log("Entered Postal Code", true);
		
		rp.getUserName().sendKeys(lib.getDataFromPrpoertyFile("UserName"));
		Reporter.log("Entered Username", true);
		
		rp.getPassword().sendKeys(lib.getDataFromPrpoertyFile("Password"));
		Reporter.log("Entered Password", true);
		
		rp.getConfirmPassword().sendKeys(lib.getDataFromPrpoertyFile("ConfirmPassword"));
		Reporter.log("Entered Password", true);
		
		rp.getSubmitbutton().click();
		Reporter.log("Clicked on the submit Button", true);
		
		Thread.sleep(10000);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Reporter.log("url get copied", true);
		
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(url, lib.getDataFromPrpoertyFile("RegistrationSuccessUrl"));
		
		Reporter.log("url's Verified", true);
		
		sft.assertAll();
		
	}
		
}





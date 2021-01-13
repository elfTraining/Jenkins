package com.Guru99.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.Guru99.genericLib.Base;
import com.Guru99.genericLib.FileLib;
import com.Guru99.pagerepository.FlightPage;
import com.Guru99.pagerepository.Home;


@Listeners(com.Guru99.genericLib.ListenerImp.class)
public class FlightsSearch extends Base
{
	
	FileLib lib = new FileLib();
	Home h;
	FlightPage fp;
	
	@Test
	public void flightSearchTextfieldVerification() throws InterruptedException
	{
		h = PageFactory.initElements(driver, Home.class);
		fp = PageFactory.initElements(driver, FlightPage.class);
		
		h.getFlightlink().click();
		Reporter.log("Clicked on the Flight link", true);
		Thread.sleep(3000);
		
		fp.getOneWaycheckbox().click();
		Reporter.log("Clicked on the OneWay checkbox", true);
				
		fp.getNoPassengersDD().click();
		Reporter.log("Clicked on the Passengers Dropdown", true);
		
		fp.passCount(lib.getSpecifiedDataFromExcelFile("Data", 3, 0));
		Reporter.log("Selected the number of passengers", true);
		
		fp.getDepartureDD().click();
		Reporter.log("Clicked on the Departing From dropdown", true);
		
		fp.departure(lib.getSpecifiedDataFromExcelFile("Data", 4, 2));
		Reporter.log("Selected the Departure city", true);
		
		fp.getDeparturemonthDD().click();
		Reporter.log("Clicked on the Departure Month dropdown", true);
		
		fp.departureMonth(lib.getSpecifiedDataFromExcelFile("Data", 6, 3));
		Reporter.log("Selected the Month from the Dropdown", true);
		
		fp.getDepartureDateDD().click();
		Reporter.log("Clicked on the Departure Date dropdown", true);
		
		fp.departureDay(lib.getSpecifiedDataFromExcelFile("Data", 8, 4));
		Reporter.log("Selected the Date from the Dropdown", true);
		
		fp.getArrivingDD().click();
		Reporter.log("Clicked on the Arriving In city dropdown", true);
		
		fp.arriveIn(lib.getSpecifiedDataFromExcelFile("Data", 6, 6));
		Reporter.log("Selected the Arriving city from the dropdown", true);
		
		fp.getReturingmonthDD().click();
		Reporter.log("Clicked on the Returning Month dropdown", true);
		
		fp.returnMonth(lib.getSpecifiedDataFromExcelFile("Data", 11, 7));
		Reporter.log("Selected the Returning Month from thedropdown", true);
		
		fp.getReturningdateDD().click();
		Reporter.log("Clicked on the Returning Date dropdown", true);
		
		fp.returnDate(lib.getSpecifiedDataFromExcelFile("Data", 21, 8));
		Reporter.log("Selected the Returning Date from the dropdown", true);
		
		fp.getServclasscheckbox().click();
		Reporter.log("Clicked on the Service Class Checkbox", true);
		
		fp.getAirlineDD().click();
		Reporter.log("Clicked on the Airelines dropdown", true);
		
		fp.airlines(lib.getSpecifiedDataFromExcelFile("Data", 3, 10));
		Reporter.log("Selected the Airlines from the dropdown", true);
		
		fp.getContinuebutton().click();
		Reporter.log("Clicked on the continue Button", true);
		
		Thread.sleep(10000);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Reporter.log("url get copied", true);
		
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(url, lib.getDataFromPrpoertyFile("FlightSearchurl"));
		
		Reporter.log("url's Verified", true);
		
		sft.assertAll();
		
	}
		
}





package com.Guru99.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;


public class Sample
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "./browsers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		
		WebElement ele = driver.findElement(By.xpath("//span[.='India']"));
		
		String text = ele.getText();
		Thread.sleep(3000);
		
		WebElement ele1 = driver.findElement(By.name("q"));
		ele1.click();
		ele1.sendKeys(text,Keys.ENTER);
		
		String title = driver.getTitle();
		SoftAssert sft = new SoftAssert();
		sft.assertEquals(title, "India - Google Search");
		
		System.out.println(title);
		
		sft.assertAll();
		
		driver.close();
	}
		
}





/* Created By: Shweta
 * Created Date: June 23, 2018
 * Version #:1.0
 * Class description: Verify Basic HTTP authentication                
 * Modified By:
 * Modified Date:
 */

package com.examples.seleniumTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class BasicAuthentication{


	private WebDriver driver;

	@BeforeTest
	public void setUp() {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver-v20.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	/**
	 * Method to perform basic http authentication
	 * @throws Exception 
	 */
	@Test

	public void performAuthentication() throws Exception {
		try {
		driver.get("http://admin:admin@the-internet.herokuapp.com");
		driver.findElement(By.xpath(".//a[@href='/basic_auth']")).click();
	    String sActual_MessageOnPage=  driver.findElement(By.xpath(".//div[@class='example']/p")).getText();
	    String sExpected_MessageOnPage="Congratulations! You must have the proper credentials.";
		//Adding a checkpoint,if the Assert fails,test case fails and execution stops
	    Assert.assertEquals(sActual_MessageOnPage, sExpected_MessageOnPage);	
				}

		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	/**
	 * @AfterTest Below method will quit from all the Webdriver instances by closing all the associated windows
	 */
	@AfterTest

	public void tearDown() throws Exception {
		driver.quit();

	}

}

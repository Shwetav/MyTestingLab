/* Created By: Shweta
 * Created Date: June 23, 2018
 * Version #:1.0
 * Class description: Verify FileUpload               
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


public class FileUpload {

	private WebDriver driver;

	@BeforeTest
	public void setUp() {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver-v20.exe");
		driver = new FirefoxDriver();
		driver.get("http://the-internet.herokuapp.com/upload");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	/**
	 * Method to upload a file from the working directory
	 */
	@Test

	public void upLoadFile() {
		try {
			// file details to upload
			String sFileName = "FileToUpload.txt";// TestFile.txt
			File file = new File(sFileName);
			String path = file.getAbsolutePath();
			driver.findElement(By.xpath(".//input[@id='file-upload']")).sendKeys(path);// "C:\\tools\\TestFile.txt"
			driver.findElement(By.id("file-submit")).click();
			String UploadedFiletext = driver.findElement(By.id("uploaded-files")).getText();
			// Assert.assertEquals(sFileName, UploadedFiletext);
			if (sFileName.equalsIgnoreCase(UploadedFiletext)) {
				System.out.println("######## \"" + sFileName + "\" is uploaded successfully #######");
			} else {
				System.out.println("File upload is NOT successful");
			}

		}

		catch (Exception e) {
			System.out.println(e);
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

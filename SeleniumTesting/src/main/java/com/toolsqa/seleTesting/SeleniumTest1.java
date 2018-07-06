package com.toolsqa.seleTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver-v20.exe");
		FirefoxDriver ff = new FirefoxDriver();
		ff.get("http://shop.demoqa.com/");
		ff.manage().window().maximize();
		ff.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		ff.findElement(By.xpath(".//a[@class='noo-search icon_search']")).click();
		ff.findElement(By.xpath(".//input[@type='search'][@name='s']")).sendKeys("Watch");
		ff.findElement(By.xpath(".//input[@type='search'][@name='s']")).sendKeys(Keys.ENTER);
		int resSize = ff.findElements(By.xpath(".//div[@class='products noo-row']//h3/a")).size();
		for (int i = 0; i <= resSize - 1; i++) {
			List<WebElement> myWatchList = ff.findElements(By.xpath(".//div[@class='products noo-row']//h3/a"));
			WebElement Watch = myWatchList.get(i);
			String sWatchName = Watch.getText();
			System.out.println(sWatchName);
			ff.findElement(By.xpath(".//button[text()='Add to cart']")).click();
			String sCartConfirmText = ff.findElement(By.xpath(".//div[@class='woocommerce-message']")).getText();
			System.out.println(sCartConfirmText);
			if (sCartConfirmText.replace("View Cart", "").trim()
					.equals("“" + sWatchName + "” has been added to your cart.")) {
				System.out.println("Cart msg Validation successful");
			} else {
				System.out.println("Cart msg Validation failed");
			}
			ff.navigate().back();
			ff.navigate().back();
		}
	}
}

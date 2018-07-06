package com.toolsqa.seleTesting;

import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Selenium2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
		FirefoxDriver ff = new FirefoxDriver();
		ff.get("http://shop.demoqa.com/");
		ff.manage().window().maximize();
		ff.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		ff.findElement(By.xpath(".//a[@class='noo-search icon_search']")).click();
		ff.findElement(By.xpath(".//input[@name='s']")).sendKeys("WATCH");
		ff.findElement(By.xpath(".//input[@name='s']")).sendKeys(Keys.ENTER);
		int resSize = ff.findElements(By.xpath(".//div[@class='products noo-row']//h3/a")).size();
		for (int i = 0; i <= resSize - 1; i++) {
			List<WebElement> watchList = ff.findElements(By.xpath(".//div[@class='products noo-row']//h3/a"));
			WebElement watch = watchList.get(i); // int[] nums = {1,2,3}; nums[1] = 2;
		// watchList.get(2);
			String watchname = watch.getText();
			// click watch
			watch.click();
			// add to cart
			ff.findElement(By.xpath(".//button[text()='Add to cart']")).click();
			String cartConf = ff.findElement(By.xpath(".//div[@class='woocommerce-message']")).getText();
			System.out.println(cartConf);
			if (cartConf.replace("View Cart", "").trim().equals("“" + watchname + "” has been added to your cart.")) {
				System.out.println("Cart message validation successfull");
			} else {
				System.out.println("Cart message validation failed");
			}
			ff.navigate().back();
			ff.navigate().back();
		}
	}
}
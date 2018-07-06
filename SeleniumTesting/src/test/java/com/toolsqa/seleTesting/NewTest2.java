package com.toolsqa.seleTesting;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest2 {
	
	@Parameters({ "browser" })
	@Test(groups= {"Unit Tests"})
	  public void f() {
		  System.out.println(Thread.currentThread().getId());
	  }
	  @Test(groups= {"Sanity Tests"})
	  public void f2() {
		  System.out.println(Thread.currentThread().getId());
	  }
	
	
	
	
	
	  
	  }



package com.toolsqa.seleTesting;

import org.testng.annotations.Test;


public class NewTest {
	
	private String sEmpName;
	
	@Test
	//getter and setters to access pvt data members of the class
	public String  getEmpName() {
		
		return sEmpName;
		
	}
	public void setEmpName(String name) {
		
		this.sEmpName=name;
	}
	
	
	
	
}
package com.rest;

import org.testng.annotations.Test;

public class paylolds {
	@Test 
	public static String lis(String isbn, String aisle) {
		return "{\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\n"
				+ "\"isbn\":\""+isbn+"\",\n"
				+ "\"aisle\":\""+aisle+"\",\n"
				+ "\"author\":\"John foer\"\n"
				+ "}\n"
				+ "";
	}

}

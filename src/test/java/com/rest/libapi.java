package com.rest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class libapi {
	@Test(dataProvider = "data sheet")
	public void dynamic(String isbn, String aisle)
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().header("Content-Type", "application/json").body(paylolds.lis(isbn,aisle)).
				when().post("Library/Addbook.php").then().log().all().assertThat().statusCode(200).extract().response().asString();
	JsonPath js=new JsonPath(response);
	}
	
		// For dynamic response json we 1st create the book entry and then delete that book so we wont get any error
		
	
	
//	given().header("Content-Type", "application/json").body("{\n"
//				+ "    \"ID\": \""+id+"\"\n"
//				+ "}").when().delete("Library/DeleteBook.php").then().log().all().assertThat().statusCode(200);
//		
		
	// data provider method of solving dynamic iisue
	
	@DataProvider(name = "data sheet")
	public Object[][] getdata() {
	
	return new Object[][] {{"jhk","455"},{"kjhrkg","877"},{"rfre","656"},{"gtrh","5678"}};
	
	
	}
	}
	


package com.rest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import io.restassured.path.json.JsonPath;


public class filestatic {
	@Test
	public void filed() throws IOException {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String resp=given().body(new String (Files.readAllBytes(Paths.get("/home/pramodp/Downloads/filescode.json")))).when().post("maps/api/place/add/json?key=qaclick123").
        then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js=new JsonPath(resp);
		System.out.println(js);
		
	}
	

}

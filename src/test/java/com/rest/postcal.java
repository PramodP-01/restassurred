package com.rest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

@Test
public class postcal {
	public void post() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String res = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\n" + "  \"location\": {\n" + "    \"lat\": -38.383494,\n" + "    \"lng\": 33.427362\n"
						+ "  },\n" + "  \"accuracy\": 50,\n" + "  \"name\": \"Frontline house\",\n"
						+ "  \"phone_number\": \"(+91) 983 893 3937\",\n"
						+ "  \"address\": \"29, side layout, cohen 09\",\n" + "  \"types\": [\n"
						+ "    \"shoe park\",\n" + "    \"shop\"\n" + "  ],\n"
						+ "  \"website\": \"http://google.com\",\n" + "  \"language\": \"French-IN\"\n" + "}")
				.when().post("/maps/api/place/add/json").then().log().all().statusCode(200).extract().response()
				.asString();
		JsonPath js = new JsonPath(res);

		String placeid = js.getString("place_id");
		System.out.println(placeid);

		// update place by using place id reference
		String address = "70 winter walk, USA";
		given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("{\n" + "\"place_id\":\"" + placeid + "\",\n" + "\"address\":\"70 winter walk, USA\",\n"
						+ "\"key\":\"qaclick123\"\n" + "}")
				.when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

		// get method

		String res1 = given().queryParam("key", "qaclick123").queryParam("place_id", placeid).when()
				.get("maps/api/place/get/json").then().log().ifError().assertThat().statusCode(200).extract().response()
				.asString();
		JsonPath j = new JsonPath(res1);
		String newadd = j.getString("address");
		System.out.println(newadd);
		

	}

}

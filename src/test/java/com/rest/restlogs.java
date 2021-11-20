package com.rest;

import org.testng.annotations.Test;

import io.restassured.config.LogConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class restlogs {
	@Test
	public void log() {
		given().baseUri("https://reqres.in/")
				.config(config().logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).

				when().get("/api/users?page=2").then().assertThat().statusCode(2000);
	}

}
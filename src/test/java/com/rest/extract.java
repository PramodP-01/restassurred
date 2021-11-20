package com.rest;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class extract {
	@Test
	public void extractresp() {

		String res = given().baseUri("https://reqres.in").when().get("api/users?page=2").then().log().all().assertThat()
				.statusCode(200).extract().response().asString();
		JsonPath.from(res).get("data.last_name[2]");
		// JsonPath json = new JsonPath(res.asString());
		// System.out.println("this is the response" +" "+
		// res.path("data.last_name[2]"));
		// System.out.println("this is the response" + " " +
		// json.getString("data.last_name[2]"));
		System.out.println("danger" + " " + JsonPath.from(res).get("data.last_name[2]"));

	}

}

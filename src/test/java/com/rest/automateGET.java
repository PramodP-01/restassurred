package com.rest;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class automateGET {
	@Test
	public void get() {
		given().baseUri("https://reqres.in/").when().get("/api/users?page=2").then().log().all().assertThat()
				.statusCode(200).body("data.first_name",
						hasItems("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel"), "data.size()",
						equalTo(6), "data.last_name", hasItems("Howell"));
	}

}

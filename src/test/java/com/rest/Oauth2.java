package com.rest;

import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;
public class Oauth2 {
	@Test
	public void getcode() {
		// get code trimed
		String code="https://rahulshettyacademy.com/getCourse.php?code=4/0AX4XfWiCkDPx_UX3k22C3mEAZ73K5ZQ-k9z96E2Au5Lihq-LKzo1eDK5Qx--__V4J0qShQ&scope=email%20https://www.googleapis.com/auth/userinfo.email%20openid&authuser=0&hd=onedirect.in&prompt=consent";
		String url=code.split("code=")[1];
		String codes=url.split("&scope")[0];
		System.out.println(codes);
		
		
		//get access token
		String response=given().queryParams("code", "4%2F0AX4XfWgtYdWjxQ8a7mIua6oKwc9VO_JGQay_-lqWjXMRCkfssbGf9u2EV2zb_Mq9wnsdTg"). 
		queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W").
        queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com"). 
        queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php").queryParams("grant_type", "authorization_code").
		 when().post("https://www.googleapis.com/oauth2/v4/token").then().log().all().assertThat().statusCode(200).
          extract().response().asString();
		JsonPath js=new JsonPath(response);
		String accesskey=js.get("access_token");
		
		// get actual request
		
		String responses=given().queryParam("access_token",accesskey ).
		when().get("https://rahulshettyacademy.com/getCourse.php").then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js1=new JsonPath(responses);
	 System.out.println(js1);
	}

}

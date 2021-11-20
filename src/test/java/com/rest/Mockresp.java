package com.rest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.path.json.JsonPath;

public class Mockresp {
	@Test
	public void mock() {
		JsonPath js = new JsonPath(resp.repo());

		int price = js.getInt("courses[0].price");
		System.out.println(price);
		String title = js.get("courses[2].title");
		System.out.println(title);

		// print courses title along with there prices
		int count = js.getInt("courses.size()");
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			String numtitles = js.get("courses["+i+"].title)");
			
			int prices = js.getInt("courses["+i+"].price");
			
			System.out.println(prices +" "+numtitles);
		}

		// print no of copies sold on selenium
		for (int i = 0; i < count; i++) {
			String tit = js.get("course[" + i + "].title");
			if (tit.equalsIgnoreCase("selenium")) {
				int vic = js.get("courses[" + i + "].copies");
				System.out.println(vic);
			}
		}

		// sum up all prices*copies and total the value and assert it
		int sum = 0;
		for (int i = 0; i < count; i++)

		{

			String cors = js.get("courses[" + i + "].title");
			int prs = js.getInt("courses[" + i + "].price");
			int copy = js.getInt("courses[" + i + "].copies");

			int amount = prs * copy;
			System.out.println(amount);
			sum = sum + amount;
			

		}
		System.out.println(sum);
		int purchase = js.getInt("dashboard.purchaseAmount");

		while (sum == purchase) {
			System.out.println(" your test is success");
			break;
		}

	}
}

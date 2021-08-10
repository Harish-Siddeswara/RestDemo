package com.gmaps.testcases;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import com.gmaps.payload_classes.Payload;

import static org.hamcrest.Matchers.*;

import org.hamcrest.core.IsEqual;


public class Basics {
	
	@Test
	public void addPlace()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		 var response=given().log().all()
		.queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(Payload.AddPlace())
		.when().post("/maps/api/place/add/json")
		.then().log().all()
		.assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)");
		
		
	}
	
	@Test
	public void updatePlace()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		given().log().all()
		.queryParam("key","qaclick123")
		.queryParam("place_id", "a833090bc1429eea0eb1c25a0f71091d")
		.headers("Content-Type","application/json")
		.body("{\r\n"
				+ "\"place_id\":\"a833090bc1429eea0eb1c25a0f71091d\",\r\n"
				+ "\"address\":\"Pune, India\",\r\n"
				+ "\"key\":\"qaclick123\"\r\n"
				+ "}")
		.when().put("/maps/api/place/update/json")
		.then().log().all().assertThat().body("msg", equalTo("Address successfully updated"));
	}

}

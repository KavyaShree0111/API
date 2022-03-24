package com.rmgyantra.DifferentWaysToPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateResourceUsingJsonObjectTest {
	
	@Test
	public void create() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "KavyaReddy");
		obj.put("projectName", "AmazonPrime");
		obj.put("status", "On Going");
		obj.put("teamSize", 50);
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}

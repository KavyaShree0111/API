package com.rmgyantra.DifferentWaysToPostRequest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class CreateAResourceUsingHashMap {
	
	@Test
	public void create() {
		HashMap map = new HashMap();
		map.put("createdBy", "KavyaShree");
		map.put("projectName", "ZEE5");
		map.put("status", "Completed");
		map.put("teamSize", 100);
		
		given()
		.body(map)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}
		

}

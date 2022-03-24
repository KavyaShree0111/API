package com.rmgyantra.sdet28.CRUDOperationWithBDDFeature;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
 
public class CreateResourceTest {
	
	@Test
	public void create() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Kavya");
		obj.put("projectName", "Netflix");
		obj.put("status", "Created");
		obj.put("teamSize", 10);
		
		given()
		.contentType(ContentType.JSON)
		.body(obj)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	}
}


	

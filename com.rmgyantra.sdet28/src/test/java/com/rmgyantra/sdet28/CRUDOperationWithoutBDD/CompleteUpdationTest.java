package com.rmgyantra.sdet28.CRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CompleteUpdationTest {
	
	@Test 
	public void update() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "123");
		obj.put("projectName", "Twitter12");
		obj.put("status", "On Going");
		obj.put("teamSize", 10);
		
		//Setting the pre conditions for the request for body and content type
		RequestSpecification requestspec = RestAssured.given();
		requestspec.body(obj);
		requestspec.contentType(ContentType.JSON);
		
		//Action
		Response response = requestspec.put("http://localhost:8084/projects/TY_PROJ_271");
		
		//Post Condition : Validation and printing response in the console
		ValidatableResponse validate = response.then();
		validate.assertThat().statusCode(200);
		validate.assertThat().contentType(ContentType.JSON);
		validate.log().all();
	}
}

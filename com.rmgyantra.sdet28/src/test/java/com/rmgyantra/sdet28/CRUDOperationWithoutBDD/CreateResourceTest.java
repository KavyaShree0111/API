package com.rmgyantra.sdet28.CRUDOperationWithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateResourceTest {
	
	@Test
	public void Create() {
		
		Random random = new Random();
		int ran = random.nextInt(5000);
		
		//Create an object for jsonObject class and pass json body 
		JSONObject obj = new JSONObject();
		
		//Passing Key value pair using put method
		obj.put("createdBy", "Kavya"+ran);
		obj.put("projectName", "Twitter9876"+ran);
		obj.put("status", "Completed");
		obj.put("teamSize", 10);
		
		//Setting the pre conditions for the request for body and content type
		RequestSpecification requestspec = RestAssured.given();
		requestspec.contentType(ContentType.JSON);
		requestspec.body(obj);
		
		//Action
		 Response response = requestspec.post("http://localhost:8084/addProject");
		 
		 //Post Condition : Validation and printing response in the console
		 ValidatableResponse vaidate = response.then();
		 vaidate.assertThat().statusCode(201);
		 vaidate.assertThat().contentType(ContentType.JSON);
		 vaidate.log().all();
		 
	}
}

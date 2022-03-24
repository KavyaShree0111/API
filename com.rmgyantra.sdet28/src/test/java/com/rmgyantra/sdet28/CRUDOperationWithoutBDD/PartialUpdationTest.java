package com.rmgyantra.sdet28.CRUDOperationWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PartialUpdationTest {
	
	@Test
	public void updation() {
		
    //Passing Key value pair using put method	
	JSONObject obj = new JSONObject();
	obj.put("name", "Kavya");
	obj.put("job", "trainee");
	
	//Setting the pre conditions for the request for body and content type
	RequestSpecification requestspec = RestAssured.given();
	requestspec.body(obj);
	requestspec.contentType(ContentType.JSON);
	
	//Action
	Response response = requestspec.patch("https://reqres.in/api/users?page=2");
	
	System.out.println(response.contentType());
	
	ValidatableResponse validate = response.then();
	
	validate.log().all();
		
	}

}

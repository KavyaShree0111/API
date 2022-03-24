package com.rmgyantra.sdet28.CRUDOperationWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllTheResourcesTest {
	
	@Test
	public void getResource() {
		
		//Performing Get action using rest assured class get() method
		Response response = RestAssured.get("http://localhost:8084/projects");
		
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("Connection"));
		
		// response.prettyPrint(); //It will print the value without header
		
		// response.prettyPeek(); //It wil print the values with header
		
		// System.out.println(response.asString()); //It will print the values in single line
		
		ValidatableResponse validate = response.then(); 
		validate.log().all();
	}

}

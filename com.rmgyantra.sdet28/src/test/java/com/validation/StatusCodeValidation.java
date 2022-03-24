package com.validation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StatusCodeValidation {
	
	@Test
	public void validate() {
		Response response = when()
		.get("http://localhost:8084/projects");
		
		response.then().log().all();
		
		response.getStatusCode();
			}

}

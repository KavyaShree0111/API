package com.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class HeaderValidationTest {
	
	@Test
	public void validation() {
		String expectedContentType = "application/json";
		String expectedVaryValueHeader = "Access-Control-Request-Headers";
	
		Response response = when()
		.get("http://localhost:8084/projects");
		
		String actualContentType = response.getContentType();
		String actualVaryValueHeader= response.getHeader("Vary");
		
		response.then().log().all();
		
		Assert.assertEquals(expectedContentType, actualContentType);
		Assert.assertEquals(expectedVaryValueHeader, actualVaryValueHeader);
		
	}

}

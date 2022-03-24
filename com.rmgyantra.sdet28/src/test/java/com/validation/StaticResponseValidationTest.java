package com.validation;

import static org.junit.Assert.assertThat;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest {
	
	@Test
	public void create() {
		 String expectedProjectId="TY_PROJ_221";
		 Response response = when()
		.get("http:localhost:8084/projects");
		 
		 String actualPorjectId = response.jsonPath().get("[1].projectId");
		 System.out.println(actualPorjectId);
		 
		 response.then()
		 .assertThat().statusCode(200).contentType(ContentType.JSON).log().all();
		 
		 Assert.assertEquals(expectedProjectId, actualPorjectId);	
	
	}

}

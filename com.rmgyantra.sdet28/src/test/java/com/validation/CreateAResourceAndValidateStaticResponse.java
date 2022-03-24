package com.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.errorprone.annotations.RestrictedApi;
import com.rmgyantra.PojoClass.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class CreateAResourceAndValidateStaticResponse {
	
	@Test
	public void createAndValidate() {
		 String expectedProjectName = "PostmanAPI12";
		
		PojoLibrary obj = new PojoLibrary("KavyaKish12", "PostmanAPI12", "Completed", 10);
		
		Response response = given()
		.body(obj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject");
		
		String actualProjectName = response.jsonPath().getString("projectName");
		System.out.println(actualProjectName);
		
		response.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();
		
		Assert.assertEquals(expectedProjectName, actualProjectName);
		
		
		
		
	}

}

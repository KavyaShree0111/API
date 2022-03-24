package com.rmgyantra.DifferentWaysToPostRequest;

import org.testng.annotations.Test;

import com.rmgyantra.PojoClass.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateAResoureUsingPojoClassTest {
	
	@Test
	public void create()
	{
		PojoLibrary pojo = new PojoLibrary("KavyaKish", "API", "On Going", 40);
		
		given()
		.body(pojo)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON).log().all();
		
	}

}

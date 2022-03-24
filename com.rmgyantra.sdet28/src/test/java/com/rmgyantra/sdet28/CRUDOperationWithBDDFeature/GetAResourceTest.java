package com.rmgyantra.sdet28.CRUDOperationWithBDDFeature;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAResourceTest {
	
	@Test
	public void getResources() {
		when()
		.get("http://localhost:8084/projects")
		
	   .then()
	   .assertThat().statusCode(200)
	   .and()
	   .assertThat().contentType(ContentType.JSON)
	   .log().all();
	}

}

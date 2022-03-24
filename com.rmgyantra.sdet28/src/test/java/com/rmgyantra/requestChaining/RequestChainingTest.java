package com.rmgyantra.requestChaining;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingTest {
	@Test
	public void chaining() {
		Response response = when()
		.get("http://localhost:8084/projects");
		
		String projectId = response.jsonPath().get("[1].projectId");
		
		given()
		.pathParam("projectID", projectId)
		.when()
		.delete("http://localhost:8084/projects/{projectID}")
		
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
	}

}

package com.rmgyantra.parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ParametersTest {
	
	@Test
	public void parameters() {
		given()
		.pathParam("username", "KavyaShree0111")
		.queryParam("sort", "created")
		.queryParam("page", "2")
		
		.when()
		.get("https://api.github.com/users/{username}/repos")
		.then()
		.assertThat().statusCode(200)
		.log().all();
	}
	

}

package com.rmgyantra.parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameterTest {
	
	@Test
    public void parameter() {
		
		given()
		.queryParam("page", "3")
		.when()
		.get("https://reqres.in/api/users")
		.then()
		.log().all();
	}

}

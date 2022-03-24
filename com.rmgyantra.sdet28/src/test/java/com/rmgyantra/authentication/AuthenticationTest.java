package com.rmgyantra.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class AuthenticationTest {
	
	@Test
	public void preemptiveAuthenticaion() {
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http:localhost:8084/login")
		.then().log().all();
	}
	
	@Test 
	public void digestAuthenticaion() {
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
		.when()
		.get("http:localhost:8084/login")
		.then().log().all();
	}

}

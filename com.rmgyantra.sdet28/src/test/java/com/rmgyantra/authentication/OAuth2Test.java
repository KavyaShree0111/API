package com.rmgyantra.authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class OAuth2Test {
	
	@Test
	public void authentication() {
		
		Response response = given()
		.formParam("client_id", "SDET28API")
		.formParam("client_secret", "5c0df5da3181223be3f57e1d72c2357d")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "https://example.com")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		
		String token = response.jsonPath().get("access_token");
		
		given()
		.auth().oauth2(token)
		.pathParam("USER_ID", 2912)
			
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		
		.then()
		.log().all();
		
		
		
		
	}

	private RequestSpecification then() {
		// TODO Auto-generated method stub
		return null;
	}

}

package com.rmgyantra.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerAuthTest {
	  @Test
	  public void authentication() {
		  given()
		  .auth().oauth2("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")
		  .when()
		  .post("https://api.github.com/users/KavyaShree0111/repos")
		  .then().log().all();
	  }

}

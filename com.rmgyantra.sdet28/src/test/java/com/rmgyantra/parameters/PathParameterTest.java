package com.rmgyantra.parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameterTest {	
	@Test
	public void parameters() {
		String projectID="TY_PROJ_218";
		given()
		.pathParam("projectID", projectID)
		.when()
		.delete("http://localhost:8084/projects/{projectID}")
		.then()
		.assertThat().statusCode(204)
		.log().all();
		
	}

}

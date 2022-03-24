package com.rmgyantra.sdet28.CRUDOperationWithBDDFeature;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CompleteUpdationTest {
	
	@Test
	public void updation() {
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Kavya");
		obj.put("projectName", "Hotstar");
		obj.put("status", "Completed");
		obj.put("teamsize", 20);
		
		given()
		.contentType(ContentType.JSON)
		.body(obj)
		
		.when()
		.put("http://localhost:8084/projects/TY_PROJ_222")
		
		.then()
		.assertThat().contentType(ContentType.JSON)
		.statusCode(200)
		.log().all();
	}

}

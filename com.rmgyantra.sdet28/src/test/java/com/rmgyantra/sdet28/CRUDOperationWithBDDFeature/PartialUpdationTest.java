package com.rmgyantra.sdet28.CRUDOperationWithBDDFeature;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PartialUpdationTest {
	
	@Test
	public void update() {
		JSONObject obj = new JSONObject();
		obj.put("name", "Kavya");
		obj.put("job", "SDET");
		
		given()
		.contentType(ContentType.JSON)
		.body(obj)
		
		.when()
		.patch("https://reqres.in/api/users/2")
		
		.then()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
		
		
		
	
	}

}

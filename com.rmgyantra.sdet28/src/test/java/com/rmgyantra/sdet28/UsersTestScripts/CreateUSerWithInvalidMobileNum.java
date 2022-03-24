package com.rmgyantra.sdet28.UsersTestScripts;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUSerWithInvalidMobileNum {
	
	@Test
	public void createUser() {
		JSONObject obj = new JSONObject();
		obj.put("designation", "SDETEngineer");
		obj.put("dob", "06/04/1994");
		obj.put("email", "kishore@gmail.com");
		obj.put("empName", "Kishore123");
		obj.put("experience", 5);
		obj.put("mobileNo", "98765abcde");
		obj.put("project", "RestWebService123"); 
		obj.put("role", "APIDeveloper123"); 
		obj.put("username", "Kish123"); 
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/employees")
		
		.then()
		.assertThat().statusCode(201).contentType(ContentType.JSON)
		.log().all();

}
}
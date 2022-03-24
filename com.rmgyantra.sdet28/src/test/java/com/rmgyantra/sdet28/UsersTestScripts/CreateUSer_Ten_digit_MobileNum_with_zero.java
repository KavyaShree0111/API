package com.rmgyantra.sdet28.UsersTestScripts;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateUSer_Ten_digit_MobileNum_with_zero {
	
	@Test
	public void createUser() {
		JSONObject obj = new JSONObject();
		obj.put("designation", "SDETEngineer");
		obj.put("dob", "06/04/1994");
		obj.put("email", "kishore@gmail.com");
		obj.put("empName", "Kishore");
		obj.put("experience", 5);
		obj.put("mobileNo", "98765abcde");
		obj.put("project", "RestWebService"); 
		obj.put("role", "APIDeveloper"); 
		obj.put("username", "Kish"); 
		
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

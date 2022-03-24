package com.rmgyantra.sdet28.UsersTestScripts;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateUserTests {
	
	@Test
	public void createUser() {
		
		Random random = new Random();
		int ran=random.nextInt(5000);
		
		JSONObject obj = new JSONObject();
		obj.put("designation", "SDETEngineer"+ran);
		obj.put("dob", "01/11/1996");
		obj.put("email", "kavya@gmail.com");
		obj.put("empName", "KavyaReddy"+ran);
		obj.put("experience", 2);
		obj.put("mobileNo", "9876543210");
		obj.put("project", "APIAutomation"+ran); 
		obj.put("role", "AutomationEngineer"+ran); 
		obj.put("username", "Kavya"+ran); 
		
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

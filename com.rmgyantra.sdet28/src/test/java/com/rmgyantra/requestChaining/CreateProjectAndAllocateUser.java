package com.rmgyantra.requestChaining;

import org.testng.annotations.Test;

import com.rmgyantra.PojoClass.PojoLibrary;
import com.rmgyantra.PojoClass.PojoLibraryForCreateUser;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateProjectAndAllocateUser {
	
	@Test
	public void chaining() {
		
		Random random = new Random();
		int ran = random.nextInt(5000);
		
		
		//created an object of Pojo class for creating a resource
		PojoLibrary pobj = new PojoLibrary("Kavya", "Ferrari"+ran, "Completed", 70);
		
		//pre conditions for the 1st request
		Response response = given()
		.body(pobj)
		.contentType(ContentType.JSON)
		
		//actions
		.when()
		.post("http://localhost:8084/addProject");
		String actualProjectName=response.jsonPath().get("projectName");
		
		response.then()
		.assertThat().statusCode(201).log().all();
		
		//preconditions for the 2nd request
		
		String expectedEmpName = "KavyaReddyK123";
		PojoLibraryForCreateUser epobj = new PojoLibraryForCreateUser("SDETinAPI"+ran, "01-11-1996", "kavyashree@gmail.com", "KavyaReddyK", 01, "9988776655", actualProjectName, "Engineer"+ran, expectedEmpName);
		
		Response res = given()
		.body(epobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/employees");
		
		res.then().log().all();
		
		String actualEmpoyeeName=res.jsonPath().get("employeeName");
		res.then().assertThat().statusCode(201);
	}

}

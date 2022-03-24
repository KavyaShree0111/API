package com.rmgyantra.requestChaining;

import org.testng.annotations.Test;

import com.rmgyantra.PojoClass.PojoLibraryForCreateUser;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateAndDeleteUser {
	@Test
	public void chaining() {
		
		Random random = new Random();
		int ran = random.nextInt(5000);
		
	PojoLibraryForCreateUser pobj = new PojoLibraryForCreateUser("SDETinAPI"+ran, "01-11-1996", "kavyashree@gmail.com", "KavyaKish"+ran, 01, "9988776655", "BMW3Series"+ran, "Engineer"+ran, "KavyaKish01"+ran);
	
	     Response response = given()
		.body(pobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/employees");
		 String actualEmpID = response.jsonPath().get("employeeId");
		
		 response.then()
		 
		.assertThat().statusCode(201)
	    .assertThat().contentType(ContentType.JSON)
	    .log().all();
		 
		 given()
		 .pathParam("empId", actualEmpID)
		 .when()
		 .delete("http://localhost:8084/employees/{empId}")
		 .then()
		 .assertThat().statusCode(204)
		 .log().all();
		    
	    
		
	
	}

}

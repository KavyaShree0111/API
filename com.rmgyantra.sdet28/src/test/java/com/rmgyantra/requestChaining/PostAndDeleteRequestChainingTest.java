package com.rmgyantra.requestChaining;

import org.testng.annotations.Test;

import com.rmgyantra.PojoClass.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class PostAndDeleteRequestChainingTest {
	@Test
	public void chaining() {
		
		Random random = new Random();
		int ran=random.nextInt(5000);
		
		PojoLibrary pobj = new PojoLibrary("Kavya", "BMW"+ran,"On-Going", 80);
		
	     Response response = given()
		 .body(pobj)
		 .contentType(ContentType.JSON)
	     .when()
		 .post("http://localhost:8084/addProject");
	     String actualproName = response.jsonPath().get("projectId");
	     response.then()
	     .assertThat().statusCode(201)
	     .assertThat().contentType(ContentType.JSON)
	     .log().all();
	    
	     given()
	    .pathParam("projectId", actualproName)
	    .when()
	    .delete("http://localhost:8084/projects/{projectId}")
	    .then()
	    .assertThat().statusCode(204)
	    .log().all();
	}

}

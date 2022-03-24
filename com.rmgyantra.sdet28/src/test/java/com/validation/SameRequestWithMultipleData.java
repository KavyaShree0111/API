package com.validation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgyantra.PojoClass.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class SameRequestWithMultipleData {
	
	@Test(dataProvider = "data")
	public void create(String createdBy, String projectName, String status, int teamSize) {
		
		PojoLibrary obj = new PojoLibrary(createdBy, projectName, status, teamSize);
		
		given()
		.body(obj)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201).log().all();
	}
	
	@DataProvider
	public Object[][] data() {
		Object[][] objArray = new Object[4][4];
		
		objArray[0][0]="Kavya";
		objArray[0][1]="Data1";
		objArray[0][2]="Completed";
		objArray[0][3]=200;
		
		objArray[1][0]="Kavya";
		objArray[1][1]="Data2";
		objArray[1][2]="Completed";
		objArray[1][3]=300;
		
		objArray[2][0]="Kavya";
		objArray[2][1]="Data3";
		objArray[2][2]="Completed";
		objArray[2][3]=400;
		
		objArray[3][0]="Kavya";
		objArray[3][1]="Data4";
		objArray[3][2]="Completed";
		objArray[3][3]=500;
		
		return objArray;	
	}

}

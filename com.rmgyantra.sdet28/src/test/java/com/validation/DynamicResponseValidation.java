package com.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {
	
	@Test
    public void validate() {
		
		String expectedProjectId = "TY_PROJ_221";
		
		Response response = when()
		.get("http://localhost:8084/projects");
		
		List<String> actuaProjectIds = response.jsonPath().get("projectId");	
		
		boolean flag=false;
		for(String projectId:actuaProjectIds) {
			if (projectId.equals(expectedProjectId)) {
				System.out.println("expectedProjectId : TY_PROJ_221 Id is matching with List of actual ProjectIds");
				flag=true;
			}
		}
		response.then().log().all();
		
		Assert.assertEquals(flag, true);
	}
}

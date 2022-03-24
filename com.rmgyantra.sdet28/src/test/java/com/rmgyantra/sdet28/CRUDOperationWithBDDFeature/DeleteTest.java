package com.rmgyantra.sdet28.CRUDOperationWithBDDFeature;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteTest {
	
	@Test
	public void delete() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_239")
		
		.then()
		.assertThat().statusCode(204)
		.log().all();
	}

}

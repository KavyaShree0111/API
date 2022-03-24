package com.validation;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ValidateUsingHamcrestTest {

	@Test
	public void validate() {
		when()
		.get("http://localhost:8084/projects")
		
		.then()
		.assertThat().time(Matchers.lessThan(500L), TimeUnit.MILLISECONDS)
		.assertThat().body("[1].projectName",Matchers.equalTo("kavya_pro-3715"))
		.assertThat().contentType(Matchers.equalTo("application/json"))
		.log().all();
		
	}
}

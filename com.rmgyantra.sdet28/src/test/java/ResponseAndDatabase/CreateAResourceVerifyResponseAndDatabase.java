package ResponseAndDatabase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

import com.rmgyantra.PojoClass.PojoLibrary;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CreateAResourceVerifyResponseAndDatabase {
	
	
	
	@Test
	public void verification() throws Throwable {
		
		Random random = new Random();
		int ran=random.nextInt(5000);
		
		String expectedProjectName = "APIProject"+ran;
		PojoLibrary pojo = new PojoLibrary("createdBy", expectedProjectName, "Completed", 50);
		
		Response response = given()
		.body(pojo)
		.contentType(ContentType.JSON)
		.when()
		.post("http://localhost:8084/addProject");
		
		String actualProjectName=response.jsonPath().get("projectName");
		response.then().log().all();
		
		Assert.assertEquals(actualProjectName, expectedProjectName);
		
		
		//Connect to database for verification
		Connection connection = null;
		try {
			
			//Register the driver
			
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			
			//Establish the database connection
			
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
			
			
			//Issue the create statement
			Statement statement = connection.createStatement();
			
			
			String query = "select * from project";
	    	  ResultSet result = statement.executeQuery(query);
	    	  boolean flag=false;
	    	  while (result.next()) {
	    		 if(expectedProjectName.equals(result.getString(4))) {
	    			 System.out.println("projectName is displayed in database");
	    			 flag=true;
	    		 }
	    		 }
	          //verifying in database   	  
	    	  Assert.assertTrue(flag);
				
			
			
		} catch (Exception e) {
			
		}
		
		finally {
		//Close the database connection
		connection.close();
		System.out.println("Connection closed");
		
		
		
		}
		
		
	}

}

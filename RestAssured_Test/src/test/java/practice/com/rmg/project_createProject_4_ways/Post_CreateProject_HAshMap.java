package practice.com.rmg.project_createProject_4_ways;
import  io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Post_CreateProject_HAshMap {
 /**
  * Create Project with HAshMAp class
  */
	@Test
	public void createProject() {
		
		HashMap map = new HashMap();
		map.put("createdBy", "deepak");
		map.put("projectName", "SBI_Hubli");
		map.put("status", "Completed");
		map.put("teamSize", 10);
		
		
		given()
		  .contentType(ContentType.JSON)
		  .body(map)
	    .when()
	       .post("http://localhost:8084/addProject")
	    .then()
	      .log().all()
	      .and()
	      .assertThat().statusCode(201);
  
   
          
   
          
          
	}

}

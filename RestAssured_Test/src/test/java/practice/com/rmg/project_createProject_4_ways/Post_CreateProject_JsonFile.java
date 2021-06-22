package practice.com.rmg.project_createProject_4_ways;
import  io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Post_CreateProject_JsonFile {
 /**
  * Create Project with JSON file
  */
	@Test
	public void createProject() {
		
	   File filName = new File("./Project_Data.json");
		
		given()
		  .contentType(ContentType.JSON)
		  .body(filName)
	    .when()
	       .post("http://localhost:8084/addProject")
	    .then()
	      .log().all()
	      .and()
	      .assertThat().statusCode(201);

 
          
          
	}

}

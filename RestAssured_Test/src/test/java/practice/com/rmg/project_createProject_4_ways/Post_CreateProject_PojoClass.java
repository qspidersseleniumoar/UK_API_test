package practice.com.rmg.project_createProject_4_ways;
import  io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmg.project.pojoObjectLib.Project;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Post_CreateProject_PojoClass {
 /**
  * Create Project with pojo class Object 
  */
	@Test
	public void createProject() {
		
		Random random = new Random();
		int randonInt = random.nextInt(2000);
		
	   /*create an object Project pojo class*/
		Project pojoObj = new Project("deepak", "SBI_"+randonInt, "Completed",10);
		
	
		given()
		  .contentType(ContentType.JSON)
		  .body(pojoObj)
	    .when()
	       .post("http://localhost:8084/addProject")
	    .then()
	      .log().all()
	      .and()
	      .assertThat().statusCode(201);
  
   
          
   
          
          
	}

}

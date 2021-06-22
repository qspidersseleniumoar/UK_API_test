package practice.com.rmg.projecttest_bdd;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Post_CreateProject_bdd {

	@Test
	public void createProject() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "deepak");
		jobj.put("projectName", "SBI_abc");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 10);
		
		given()
		  .contentType(ContentType.JSON)
		  .body(jobj)
	    .when()
	       .post("http://localhost:8084/addProject")
	    .then()
	      .log().all()
	      .and()
	      .assertThat().statusCode(201);
  
   
          
          
	}

}

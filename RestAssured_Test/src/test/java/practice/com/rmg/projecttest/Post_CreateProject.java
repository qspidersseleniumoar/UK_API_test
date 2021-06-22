package practice.com.rmg.projecttest;
import  io.restassured.RestAssured;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Post_CreateProject {

	@Test
	public void createProject() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "deepak");
		jobj.put("projectName", "SBI_");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 10);
		
          RequestSpecification reqSecp =  RestAssured.given();
          reqSecp.contentType(ContentType.JSON);
          reqSecp.body(jobj);
          
          Response resp = reqSecp.post("http://localhost:8084/addProject");
          
          ValidatableResponse vresp = resp.then();
           vresp.assertThat().statusCode(201);
           vresp.assertThat().contentType("application/json");
           vresp.log().all();
   
          
          
	}

}

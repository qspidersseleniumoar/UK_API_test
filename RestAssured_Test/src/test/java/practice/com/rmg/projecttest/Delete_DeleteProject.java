package practice.com.rmg.projecttest;
import  io.restassured.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Delete_DeleteProject {

	@Test
	public void getAllProject() {
          Response resp =  RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1202");

             ValidatableResponse vresp = resp.then();
              vresp.assertThat().statusCode(204);
              vresp.assertThat().contentType("application/json");
              vresp.log().all();
          
   
          
          
	}

}

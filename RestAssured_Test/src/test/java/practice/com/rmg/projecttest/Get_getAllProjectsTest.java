package practice.com.rmg.projecttest;
import io.restassured.RestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Get_getAllProjectsTest {

	@Test
	public void getAllProject() {
		
          Response resp =  RestAssured.get("http://localhost:8084/projects");
          
             ValidatableResponse vresp = resp.then();
              vresp.assertThat().statusCode(200);
              vresp.assertThat().contentType("application/json");
              vresp.log().all();
          
   
          
          
	}

}

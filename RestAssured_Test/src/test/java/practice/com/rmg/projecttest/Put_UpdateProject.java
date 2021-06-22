package practice.com.rmg.projecttest;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Put_UpdateProject {

	@Test
	public void updatePRoject() {
		
		JSONObject jobj = new JSONObject();
		jobj.put("createdBy", "deepak");
		jobj.put("projectName", "SBI_1234567");
		jobj.put("status", "Completed");
		jobj.put("teamSize", 10);
		
          RequestSpecification reqSecp =  RestAssured.given();
          reqSecp.contentType(ContentType.JSON);
          reqSecp.body(jobj);
          
          Response resp = reqSecp.put("http://localhost:8084/projects/TY_PROJ_1203");

          
          ValidatableResponse vresp = resp.then();
           vresp.assertThat().statusCode(200);
           vresp.assertThat().contentType("application/json");
           vresp.log().all();
   
          
          
	}

}

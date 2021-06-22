package practice.com.rmg.responseValidation;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CaptureAllREpoNameGit_COMPLEX_Response {
	
	   @Test

		public void getAllRepoForUSer() {
			Response resp = given()
			                 .pathParam("gitUser", "qspidersseleniumoar")
			                 .auth().oauth2("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")
					      .when()
					         .get("https://api.github.com/users/{gitUser}/repos?sort=created&per_page=100");
			
		          List<String>  lst = resp.jsonPath().get("name");
			
			      for(String str : lst) {
			    	  System.out.println(str);
			      }
			
		}
	

}

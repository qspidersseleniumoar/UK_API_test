package practice.com.rmg.api.autentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class AuthenticationTest {
	
	//@Test
	public void sampleTest() {
		  //server should ask for credentials , then restAssured provide the data
		
		given()
		  .auth()
		  .preemptive().basic("rmgyantra", "rmgy@9999")
	   .when()
	       .get("http://localhost:8084/projects")
      .then()
           .log().all();
          
	}
	
	
	//@Test
	public void desgistiveAuth() {
		  //then restAssured provide the credentials before server is asking for it 
		
		given()
		  .auth()
		  .digest("rmgyantra", "rmgy@9999")
	   .when()
	       .get("http://localhost:8084/projects")
      .then()
           .log().all();
          
	}
	
	//@Test
	public void basicAuth() {
		  //then  provide the credentials before server is asking for it 
		
		given()
		  .auth()
		  .basic("rmgyantra", "rmgy@9999")
	   .when()
	       .get("http://localhost:8084/projects")
      .then()
           .log().all();
          
	}
	
	
	@Test
	public void bearerTokenAuth() {
		  //bearer token Authentication
		
		given()
		  .auth()
		  .oauth2("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")
	   .when()
	       .get("https://api.github.com/users/qspidersseleniumoar/repos")
    .then()
         .log().all();
        
	}


	
}

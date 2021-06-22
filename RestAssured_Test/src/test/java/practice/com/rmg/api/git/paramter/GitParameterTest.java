package practice.com.rmg.api.git.paramter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GitParameterTest {
	/**
	 * execute api with path parameter
	 */
	//@Test
	public void getAllRepoForUSer() {
		given()
		   .pathParam("gitUser", "nvnsoni")
		   .auth().oauth2("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")
		.when()
		  .get("https://api.github.com/users/{gitUser}/repos")
		.then()
		  .log().all();
		
	}
	
	/**
	 * execute api with query parameter
	 */
	@Test
	public void queryParamTest() {
		given()
		   .pathParam("gitUser", "nvnsoni")
		   .queryParam("sort", "created")
		   .auth().oauth2("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")
		.when()
		  .get("https://api.github.com/users/{gitUser}/repos")
		.then()
		  .log().all();
		
	}
	

}

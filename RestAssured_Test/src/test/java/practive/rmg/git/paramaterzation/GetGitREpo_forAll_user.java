package practive.rmg.git.paramaterzation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetGitREpo_forAll_user {
/**
 *  Parameterization : in order to execute same API-Request with different type of data

 */
	@Test (dataProvider = "provideDataFor_getAllRepoForUSer")
	public void getAllRepoForUSer(String par1 , String par2) {		
		given()
		   .pathParam("gitUser", par1)
		   .queryParam("sort" , par2)
		   .auth().oauth2("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")
		.when()
		  .get("https://api.github.com/users/{gitUser}/repos")
		.then()
		  .log().all()
		  .assertThat().statusCode(200);		  
	}
	
	@DataProvider
	public Object[][] provideDataFor_getAllRepoForUSer() {
		Object[][] objArr = new Object[4][2];
		
		objArr[0][0] = "Akshay-Kumar95";
		objArr[0][1] = "created";
		
		objArr[1][0] = "MitaRani";
		objArr[1][1] = "created";
		
		objArr[2][0] = "hhthjuortrtetet";
		objArr[2][1] = "created";
		
		objArr[3][0] = "nvnsoni";
		objArr[3][1] = "created";
		return objArr;
	}
}

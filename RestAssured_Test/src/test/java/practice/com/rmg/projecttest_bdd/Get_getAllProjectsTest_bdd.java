package practice.com.rmg.projecttest_bdd;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Get_getAllProjectsTest_bdd {

	@Test
	public void getAllProject() {
          
      when()                                    //Action :Actual http Request 
         .get("http://localhost:8084/projects")
      .then()                                   //PostCondition : validation
          .assertThat().statusCode(200)
          .and()
          .assertThat().contentType(ContentType.JSON)
          .and()
          .log().all();
          
          
	}

}

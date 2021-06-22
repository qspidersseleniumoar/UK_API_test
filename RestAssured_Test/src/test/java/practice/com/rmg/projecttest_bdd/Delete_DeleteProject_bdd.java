package practice.com.rmg.projecttest_bdd;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Delete_DeleteProject_bdd {

	@Test
	public void getAllProject() {

          
        when()
          .delete("http://localhost:8084/projects/TY_PROJ_002")
        .then()
          .assertThat().statusCode(204)
          .and().log().all();
          
          
	}

}

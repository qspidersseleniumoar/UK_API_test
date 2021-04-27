package com.rmg.projecttest;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetSingleProjectTest {


@Test
public void apitest_2() {
		
		when()
		  .get("http://localhost:8085/projects/TY_PROJ_003")
		.then()
		  .log().all();

	}

}

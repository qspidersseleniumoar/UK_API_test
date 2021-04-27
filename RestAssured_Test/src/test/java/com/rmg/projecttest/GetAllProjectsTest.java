package com.rmg.projecttest;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetAllProjectsTest {

	@Test
	public void apitest_2() {
		when()
		  .get("http://localhost:8085/projects")
		.then()
		  .log().all();

	}

}

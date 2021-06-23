package com.rmg.api.projecttest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rmg.api.generic.utility.BaseAPIClass;
import com.rmg.api.generic.utility.DataBaseUtilities;
import com.rmg.api.generic.utility.IEndPoints;
import com.rmg.api.generic.utility.JavaUtility;
import com.rmg.api.project.pojoObjectLib.Project;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import java.util.List;

public class CreateProjectwith_OnGoing_statusTest2 extends BaseAPIClass {
   @Test
   public void createAndVerify() throws Throwable {

	   
	   String project_name="Adarsh_sdet16_"+jLib.getRandomData();
	   String status = "On Going";
	   String actProjectName_ResponseData = null;
	   String actProjectName_DataBaseValue = null;
	   
        Project projjectPojoObj = new Project("deepak", project_name, status, 10);
	   
        Response response = given()
						     .contentType(ContentType.JSON)
						   	 .body(projjectPojoObj)
						   	 .when()
						     	.post(IEndPoints.addProject_EP);
        
	                        response.
	                            then().log().all();
	   //capture projectName from the API response in done
	    actProjectName_ResponseData = response.jsonPath().getString("projectName");
	    String actStatus_ResponseData = response.jsonPath().getString("status");
	    
	  //getting the value from database 
	    String querry="select * from project;";
	    actProjectName_DataBaseValue = db.executeQuerryAndGetData(querry, 4, project_name); //verify the data in DB

		   
		   //testng assertion
		   Assert.assertEquals(actProjectName_ResponseData, actProjectName_DataBaseValue);    
		   Assert.assertEquals(actStatus_ResponseData, status);
   }
}

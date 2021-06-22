package practice.com.rmg.responseValidation;

import static io.restassured.RestAssured.when;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ValidateResponseBody {
	
 /**
  * validate the first projectNAme (HDFC)  is available  in the STATIC response 
  */
	//@Test
	public void getAllProjectValidateStaticResponse() {
		String expectedProjectName = "hdfc";
          
      Response resp = when()                                  
                       .get("http://localhost:8084/projects");
      
      
      resp.then()                                   
          .assertThat().statusCode(200)
          .log().all();
      
      String actprojectNAme  = resp.jsonPath().get("[0].projectName");
      System.out.println("ProjectNAme === > "+actprojectNAme);
      Assert.assertEquals(expectedProjectName, actprojectNAme);
          
          
	}
	
	
	
 /**
  * validate the any projectNAme (apple)  is available  in the Dynamic response 
  */
	@Test
	public void getAllProjectAndValidateDynamicResponse() {
		String expectedProjectName = "Apple";
        boolean flag = false;  
      Response resp = when()                                  
                       .get("http://localhost:8084/projects");
      
      
      resp.then()                                   
          .assertThat().statusCode(200)
          .log().all();
      
      List<String> list  = resp.jsonPath().get("projectName");
     
       
      for(String str : list) {
    	  if(expectedProjectName.equals(str)) {
    		  System.out.println(expectedProjectName + "==>available==PASS");
    		  flag = true;
    		  break;
    	  }
      }
          
          Assert.assertEquals(flag, true);
          System.out.println(list.size());
	}
	

	

}

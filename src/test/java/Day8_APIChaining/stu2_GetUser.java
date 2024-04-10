package Day8_APIChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class stu2_GetUser 
{	
	@Test
	public void test2_GetUser(ITestContext context) 
	{
		//int id=(String)context.getAttribute("user_id");      //only test
		String id=(String) context.getSuite().getAttribute("user_id");   //complte suite
				
		given()
			.pathParam("id", id)
		.when()
			.get("http://localhost:3000/students/{id}")
		
		.then()
			.statusCode(200)
			.log().all();
	}
}

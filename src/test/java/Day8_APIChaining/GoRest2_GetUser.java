package Day8_APIChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class GoRest2_GetUser 
{	
	@Test
	public void test2_GetUser(ITestContext context) 
	{
		//int id=(Integer)context.getAttribute("user_id");      //only test
		int id=(Integer)context.getSuite().getAttribute("user_id");   //complte suite
		
		
		String BToken="5dcd39aea9dc12e2339427a9db97bdb24739d1889d505e97a76448a466a30153";
		
		given()
			.header("Authorization","Bearer "+BToken)
			.pathParam("id", id)
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(200)
			.log().all();
	}
}

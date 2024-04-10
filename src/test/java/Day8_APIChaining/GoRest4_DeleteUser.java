package Day8_APIChaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GoRest4_DeleteUser
{	
	@Test
	public void test4_DeleteUser(ITestContext context)
	{
		//int id=(Integer)context.getAttribute("user_id");    //only test
		int id=(Integer)context.getSuite().getAttribute("user_id");   //complte suite
		
		String BToken="5dcd39aea9dc12e2339427a9db97bdb24739d1889d505e97a76448a466a30153";

		given()
			.header("Authorization","Bearer "+BToken)
			.pathParam("id", id)
			
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
			
		.then()
			.statusCode(204)
			.log().all();		
	}
}

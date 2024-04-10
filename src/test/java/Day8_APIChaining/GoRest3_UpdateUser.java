package Day8_APIChaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class GoRest3_UpdateUser
{
	@Test
	public void test3_UpdateUser(ITestContext context)
	{
		//int id=(Integer)context.getAttribute("user_id");    //only test
		int id=(Integer)context.getSuite().getAttribute("user_id");   //complete suite		
		
		String BToken="5dcd39aea9dc12e2339427a9db97bdb24739d1889d505e97a76448a466a30153";
		Faker f=new Faker();
		
		JSONObject data=new JSONObject();
			data.put("name", f.name().fullName());
			data.put("gender", "Female");
			data.put("email", f.internet().emailAddress());
			data.put("status", "active");
			
		given()
			.header("Authorization","Bearer "+BToken)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())	
			
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
			
		.then()
			.statusCode(200)
			.log().all();	
	}
}

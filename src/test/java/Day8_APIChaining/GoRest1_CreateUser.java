package Day8_APIChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class GoRest1_CreateUser 
{	
	@Test
	public void test_CreateUser(ITestContext context)
	{
		Faker f=new Faker();
		
		JSONObject data=new JSONObject();
			data.put("name", f.name().fullName());
			data.put("gender", "Male");
			data.put("email", f.internet().emailAddress());
			data.put("status", "inactive");
			
		String BToken="5dcd39aea9dc12e2339427a9db97bdb24739d1889d505e97a76448a466a30153";	
		
		 int id = given()
			.header("Authorization","Bearer "+BToken)
			.contentType("application/json; charset=utf-8")
			.body(data.toString())	
			
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
				
//		//context.setAttribute("user_id", id);    //access only within test
		context.getSuite().setAttribute("user_id", id);    //access in complete Suite	
	}
}

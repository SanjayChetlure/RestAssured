package Day8_APIChaining;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class stu3_UpdateUser
{
	@Test
	public void test3_UpdateUser(ITestContext context)
	{
		//int id=(String)context.getAttribute("user_id");    //only test
		String id=(String)context.getSuite().getAttribute("user_id");   //complete suite		
		
		Faker f=new Faker();
		
		JSONObject data=new JSONObject();
		data.put("name", f.name().fullName());
		data.put("Location", "Mumbai");
		data.put("Phone", f.number().digits(6));
		String [] cources= {"Java", "Selenium"};
		
		data.put("Cources", cources);
			
		given()
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())	
			
		.when()
			.put("http://localhost:3000/students/{id}")
			
		.then()
			.statusCode(200)
			.log().all();	
	}
}

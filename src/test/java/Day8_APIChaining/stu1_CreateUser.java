package Day8_APIChaining;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class stu1_CreateUser 
{	
	@Test
	public void test_CreateUser(ITestContext context)
	{
		Faker f=new Faker();
		
			JSONObject data=new JSONObject();
			data.put("name", f.name().fullName());
			data.put("Location", "Pune");
			data.put("Phone", f.number().digits(6));
			String [] cources= {"C", "C++"};
			
			data.put("Cources", cources);
			
		
		 String id = given()
			.contentType("application/json")
			.body(data.toString())	
			
		.when()
			.post("http://localhost:3000/students")
			.jsonPath().getString("id");
		
		
		//context.setAttribute("user_id", id);    //access only within test
		context.getSuite().setAttribute("user_id", id);    //access in complete Suite	
	
	}
}

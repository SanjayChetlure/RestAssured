package Day2_DiffrentWaysToCreatePostRequestBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ex2_PostRequestBody_using_Org_json_Library2
{
	String id;
	

	@Test(priority = 1)
	void postRequestBodyUsingOrgJSONLibrary()
	{
		JSONObject data=new JSONObject();
		data.put("name", "abc1");
		data.put("location", "india");
		data.put("phone", "1111");
		
		String [] cources= {"c", "c++"};
		data.put("cources",cources);
		
		Response resp = given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("http://localhost:3000/students");
		
		resp.then()
			.statusCode(201)
			.body("name",equalTo("abc1"))
			.body("location",equalTo("india"))
			.body("phone",equalTo("1111"))
			.body("cources[0]",equalTo("c"))
			.body("cources[1]",equalTo("c++"))
			.header("Content-Type","application/json")
			.log().all();
		
		id=resp.jsonPath().getString("id");
	}
	
	
	@Test(priority = 2)
	public void deleteRecord() 
	{
		given()
		
		.when()
			.delete("http://localhost:3000/students/"+id)
				
		.then()
			.statusCode(200);	
	}
}

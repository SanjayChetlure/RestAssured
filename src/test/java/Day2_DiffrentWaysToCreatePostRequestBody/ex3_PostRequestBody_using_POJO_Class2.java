package Day2_DiffrentWaysToCreatePostRequestBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class ex3_PostRequestBody_using_POJO_Class2 
{
	String id;

	@Test
	void postRequestBodyUsingOrgJSONLibrary()
	{
		POJO_PostRequest data=new POJO_PostRequest();
		data.setName("abc1");
		data.setLocation("india");
		data.setPhone("1111");
		
		String [] cources= {"c", "c++"};
		data.setCources(cources);
		
		Response resp = given()
			.contentType("application/json")
			.body(data)
		
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

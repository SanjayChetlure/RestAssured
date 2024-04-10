package Day2_DiffrentWaysToCreatePostRequestBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class ex1_PostRequestBody_usingHashmap2 
{	
	String id;
	
	@Test(priority = 1)
	void postRequestBodyUsingHashmap()
	{
		HashMap mp=new HashMap();
		mp.put("name", "abc1");
		mp.put("location", "india");
		mp.put("phone", "1111");
		
		String [] cources= {"c", "c++"};
		mp.put("cources",cources);
		
		 Response resp = given()
			.contentType("application/json")
			.body(mp)
		
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
			System.out.println("---ID-----"+id);
	}
	
	
	@Test(priority = 2)
	void deleteRecord()
	{
		given()
		
		.when()
			.delete("http://localhost:3000/students/"+id)
		
		.then()
			.statusCode(200);
	}
}

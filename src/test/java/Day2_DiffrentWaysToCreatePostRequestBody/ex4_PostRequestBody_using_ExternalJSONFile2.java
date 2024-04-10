package Day2_DiffrentWaysToCreatePostRequestBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class ex4_PostRequestBody_using_ExternalJSONFile2
{
	String id;
	

	@Test(priority = 1)
	void postRequestBodyUsingOrgJSONLibrary() throws FileNotFoundException
	{
		File f=new File(".\\body.json");
		FileReader fr=new FileReader(f);
		JSONTokener jk=new JSONTokener(fr);
		JSONObject data=new JSONObject(jk);
		
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

package Day2_DiffrentWaysToCreatePostRequestBody;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ex4_PostRequestBody_using_ExternalJSONFile1
{

	@Test
	void postRequestBodyUsingOrgJSONLibrary() throws FileNotFoundException
	{
		//Note: import from java.io package
		
		File f=new File(".\\body.json");
		FileReader fr=new FileReader(f);
		JSONTokener jk=new JSONTokener(fr);
		JSONObject data=new JSONObject(jk);
	
		
		given()
			.contentType("application/json")
			.body(data.toString())
		
		.when()
			.post("http://localhost:3000/students")
		
			.then()
			.statusCode(201)
			.body("name",equalTo("abc1"))
			.body("location",equalTo("india"))
			.body("phone",equalTo("1111"))
			.body("cources[0]",equalTo("c"))
			.body("cources[1]",equalTo("c++"))
			.header("Content-Type","application/json")
			.log().all();
	}
}

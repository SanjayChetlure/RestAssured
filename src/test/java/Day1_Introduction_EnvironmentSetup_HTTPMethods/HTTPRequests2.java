package Day1_Introduction_EnvironmentSetup_HTTPMethods;



import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPRequests2 
{
	int id;
	
	
	@Test(priority = 1)
	void getUsers()
	{
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();		
	}
	
	
	@Test(priority = 2)
	void createUser()
	{
		HashMap<String,String> mp=new HashMap<String,String>();
		mp.put("name", "mahesh");
		mp.put("job", "Tester");
		
		id=given()
			.contentType("application/json")
			.body(mp)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
//		.then()
//			.statusCode(201)
//			.log().all();
	}
	
	
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser()
	{
		HashMap<String,String> mp=new HashMap<String,String>();
		mp.put("name", "MAHESH");
		mp.put("job", "TESTER");
		
		given()
			.contentType("application/json")
			.body(mp)
		
		.when()
			.put("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	
	
	@Test(priority = 4,dependsOnMethods = {"createUser"})
	void deleteUser()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
	}
	
	
	

}

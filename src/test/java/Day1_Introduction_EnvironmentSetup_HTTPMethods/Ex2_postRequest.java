package Day1_Introduction_EnvironmentSetup_HTTPMethods;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class Ex2_postRequest 
{

	
	@Test
	void createUser()
	{
		HashMap<String,String> mp=new HashMap<String,String>();
		mp.put("name", "mahesh");
		mp.put("job", "Tester");
		
		given()
			.contentType("application/json")
			.body(mp)
		
		.when()
			.post("https://reqres.in/api/users")
		
		.then()
			.statusCode(201)
			.log().all();
	}

}

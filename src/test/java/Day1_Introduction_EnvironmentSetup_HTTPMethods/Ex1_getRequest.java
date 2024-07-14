package Day1_Introduction_EnvironmentSetup_HTTPMethods;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Ex1_getRequest 
{
	@Test
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
	
	


}

package Day3_Query_And_Path_Parameters_Cookies_And_Headers_Logging;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ex1_PathAndQuerryParameters2
{
	//url: https://reqres.in/api/users?page=2&id=5
	
	@Test
	public void testPathAndQuerryParameter() 
	{
		given()          //pre-reqisite
			.pathParam("myPath1", "api")
			.pathParam("myPath2", "users")
			.queryParam("page", "2")
			.queryParam("id", "5")
		
		.when()
			.get("https://reqres.in/{myPath1}/{myPath2}")		//querry para automaticaaly go wiyh this request 
																//no need to specify manually
		.then()
			.statusCode(200)
			.log().all();
	}
}

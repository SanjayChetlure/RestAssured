package Day3_Query_And_Path_Parameters_Cookies_And_Headers_Logging;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class ex3_HeadersDemo2
{
	
	@Test(priority = 1)
		public void testHeades()
		{
			given()
			
			.when()
				.get("https://google.com/")
			
			.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.and()
			.header("Content-Encoding", "gzip")
			.and()
			.header("Server", "gws")
			.log().all();
		}

}

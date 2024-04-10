package Day3_Query_And_Path_Parameters_Cookies_And_Headers_Logging;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ex4_LoggingDemo1 
{
	
	public void getLogs() 
	{
		given()        
		
		.when()
			.get("https://reqres.in/api/users?page=2&id=5")
		
		.then()
			.log().body()       //get only body
			.log().cookies()    //get only cookies
			.log().headers()   //get only headers
			.log().all();      //get all details -> body, cookie, header, status code
	}
	
	
}

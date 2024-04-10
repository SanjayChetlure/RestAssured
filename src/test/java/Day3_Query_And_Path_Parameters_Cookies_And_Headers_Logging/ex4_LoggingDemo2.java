package Day3_Query_And_Path_Parameters_Cookies_And_Headers_Logging;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class ex4_LoggingDemo2 
{
	
	//@Test(priority = 1)
	public void getAllLogs() 
	{
		given()        
		
		.when()
			.get("https://reqres.in/api/users?page=2&id=5")
		
		.then()
			.log().all();
	}
	
	//@Test(priority = 2)
	public void getOnlyBody() 
	{
		given()        
		
		.when()
			.get("https://reqres.in/api/users?page=2&id=5")
		
		.then()
			.log().body();
	}
	
	@Test(priority = 3)
	public void getOnlyCookies() 
	{
		given()        
		
		.when()
			.get("https://google.com/")
		
		.then()
			.log().cookies();
	}

}

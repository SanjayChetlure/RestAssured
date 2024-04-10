package Day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Authentications
{
	//@Test(priority = 1)
	public void AuthEx1_basic() 
	{
		given()
			.auth().basic("postman", "password")
		.when()
			.get("https://www.postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	
	//@Test(priority = 2)
	public void AuthEx2_Digest() 
	{
		given()
			.auth().digest("postman", "password")
		.when()
			.get("https://www.postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	//@Test(priority = 3)
	public void AuthEx3_preemptive() 
	{
		given()
			.auth().preemptive().basic("postman", "password")
		.when()
			.get("https://www.postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated", equalTo(true))
			.log().all();
	}
	
	
	//@Test(priority = 4)
	public void AuthEx4_BearerToken() 
	{
		String bearerToken="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";
		
		given()
			.headers("Authorization", "Bearer "+bearerToken)
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	//@Test(priority = 5)
	public void AuthEx5_Auth1() 
	{
		given()
			.auth().oauth("ConsumerKey", "ConsumerSecret", "AccessToken", "TokenSecret")
		.when()
			.get("request URL")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	//@Test(priority = 6)
	public void AuthEx6_Auth2() 
	{
		given()
			.auth().oauth2("Auth2 Token")
		.when()
			.get("request URL")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	//@Test(priority = 6)
	public void AuthEx7_ApiKey2() 
	{
		given()
			.queryParam("appid", "5120d656c622c588181f50a225d65448")
			.queryParam("q", "pune")
			.queryParam("limit", "5")
		.when()
			.get("http://api.openweathermap.org/geo/1.0/direct")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	@Test(priority = 6)
	public void AuthEx7_ApiKey1() 
	{
		given()
			.pathParam("myPath", "geo/1.0/direct")
			.queryParam("appid", "5120d656c622c588181f50a225d65448")
			.queryParam("q", "pune")
			.queryParam("limit", "5")
		.when()
			.get("http://api.openweathermap.org/{myPath}")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	
	
}

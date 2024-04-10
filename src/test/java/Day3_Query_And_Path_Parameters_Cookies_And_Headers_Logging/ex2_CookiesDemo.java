package Day3_Query_And_Path_Parameters_Cookies_And_Headers_Logging;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;


public class ex2_CookiesDemo 
{
	//@Test(priority = 1)
	public void testCookies()
	{
		given()
		
		.when()
			.get("https://google.com/")
		
		.then()
		.cookie("AEC","Ae3NU9Mf_Q1SPqLrPaGffGerZV0QKTrYZidHALiiuRm18xIMvio6fit9X-0")
		.log().all();
	}
	
	
	//@Test(priority = 2)
	public void getCookieInfo()
	{
		 Response resp = given()
		
		.when()
			.get("https://google.com/");
		
		String cookie = resp.getCookie("AEC");
		 System.out.println("----Cookie Info----"+cookie);
	}
	
	@Test(priority = 3)
	public void getAllCookies()
	{
		 Response resp = given()
		
		.when()
			.get("https://google.com/");
		
		Map<String, String> cookies = resp.cookies();
		Set<String> allCookieNames = cookies.keySet();
		
		for(String cookieName:allCookieNames)
		{
			System.out.println(cookieName+" : "+cookies.get(cookieName));
		}
	}
	
}

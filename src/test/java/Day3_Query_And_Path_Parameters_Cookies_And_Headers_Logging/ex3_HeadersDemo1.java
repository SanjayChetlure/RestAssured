package Day3_Query_And_Path_Parameters_Cookies_And_Headers_Logging;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class ex3_HeadersDemo1 
{
	
	//@Test(priority = 1)
		public void testHeades()
		{
			given()
			
			.when()
				.get("https://google.com/")
			
			.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("Content-Encoding", "gzip")
			.header("Server", "gws")
			.log().all();
		}
	
//	@Test(priority = 2)
		public void getHeadersInfo()
		{
			 Response resp = given()
			
			.when()
				.get("https://google.com/");
			
			String header = resp.getHeader("Content-Type");
			 System.out.println("----Content type----"+header);
		}
		
		
		@Test(priority = 3)   //not that must useful / as log.all() /log.headers()
		public void getAllHeadersInfo()
		{
			 Response resp = given()
			
			.when()
				.get("https://google.com/");
			
			Headers allHeader = resp.getHeaders();
			
			for(Header header:allHeader)
			{
				System.out.println(header.getName()+" : "+header.getValue());
			}
		}
		

}

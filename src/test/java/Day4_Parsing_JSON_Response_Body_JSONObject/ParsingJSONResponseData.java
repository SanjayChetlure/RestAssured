package Day4_Parsing_JSON_Response_Body_JSONObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponseData 
{
	//@Test(priority = 1)
	public void testJSONResponse1() 
	{
		//approach1: Normal way (without capturing response)
		
		given()    
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.header("Content-type", "application/json")
			.body("book[2].price", equalTo("150.50"))
			.body("book[3].title", equalTo("The Lord of Rings"));
	}
	
	
	//@Test(priority = 2)
	public void testJSONResponse2() 
	{
		//approach2: store response in a variable (with capturing response)
		
		Response resp = given()    
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/store");
		
		Assert.assertEquals(resp.getStatusCode()	, 200);
		Assert.assertEquals(resp.header("Content-Type")	, "application/json");
		
		Assert.assertEquals(resp.jsonPath().get("book[0].title").toString()	, "savings of the country");
	
		//Note: if title is not stored in same order then this approach will not work
		//    we cant write conditional/looping statement
	}
	
	
	//@Test(priority = 3)
	public void getAllTitlesFromResponse() 
	{
		//approach3: Converting Response into JSON Object
		
		Response resp = given()    
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/store");
		
		//to convert JSON resp into String format need to pass resp into JSONObject constructor
		//converting response into JSON Object type
		JSONObject jo=new JSONObject(resp.asString());      
		
		for(int i=0; i<=jo.getJSONArray("book").length()-1; i++)
		{
			String title = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(title);
		}
	}
	
	//@Test(priority = 4)
	public void verifySpecificTitleFromResponse() 
	{
		Response resp = given()    
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store");
		JSONObject jo=new JSONObject(resp.asString());      
		
		boolean titileFound=false;
		for(int i=0; i<=jo.getJSONArray("book").length()-1; i++)
		{
			String title = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			if(title.equals("Moby Dick")) 
			{
				titileFound=true;
				break;
			}
		}
		Assert.assertEquals(titileFound, true,"Failed : title not found  -   ");
	}
	
	
	@Test(priority = 5)
	public void verifyTotalPriceFromResponse() 
	{
		Response resp = given()    
			.contentType(ContentType.JSON)
		.when()
			.get("http://localhost:3000/store");
		JSONObject jo=new JSONObject(resp.asString());      
		
		double totalPrice=0;
		for(int i=0; i<=jo.getJSONArray("book").length()-1; i++)
		{
			String price = jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			totalPrice=totalPrice+ Double.parseDouble(price);
		}
		
		System.out.println(totalPrice);
		Assert.assertEquals(totalPrice, 601,"Failed : price mismatch  -   ");
	}
	
}

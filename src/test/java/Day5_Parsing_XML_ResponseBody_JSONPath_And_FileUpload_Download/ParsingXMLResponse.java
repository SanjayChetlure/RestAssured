package Day5_Parsing_XML_ResponseBody_JSONPath_And_FileUpload_Download;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLResponse 
{
	
	//@Test(priority = 1)
	public void testXMLResponse1() 
	{
		//approch1: without returning/storing response
		//validate static data 
		
		given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
			.statusCode(200)
			.header("Content-Type", "application/xml; charset=UTF-8")
			.body("TravelorInformationResponse.page", equalTo("2"))
			.body("TravelorInformationResponse.travelor.travelorInformation[0].name", equalTo("vijay bharatrao reddy"));
	}
	
	
	//@Test(priority = 2)
	public void testXMLResponse2() 
	{
		//approch2: with returning/storing response
		//validate static data 
		//perform same validation by Stroring response in variable
		
		Response resp = given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(resp.getStatusCode(), 200);
		Assert.assertEquals(resp.header("Content-Type"), "application/xml; charset=UTF-8");
		
		String page = resp.xmlPath().get("TravelorInformationResponse.page").toString();
		Assert.assertEquals(page, 1);        //page no is in string format here
		
		String name = resp.xmlPath().get("TravelorInformationResponse.travelor.travelorInformation[0].name").toString();
		Assert.assertEquals(name, "vijay bharatrao reddy");
	}
	

	//@Test(priority = 3)
	public void verifyTravelerListSize() 
	{
		//approch2: with returning/storing response
		//validate dynamic data 

		//for XML validation we use -> XMLPath
		//for JSON validation we use -> JSONObject
		
		//to convert data -> string   : toString()
		//to convert response -> string  : asString()
		
		Response resp = given()
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		XmlPath x=new XmlPath(resp.asString());  //convert entire response into string format
		List<String> TravelorList = x.getList("TravelorInformationResponse.travelor.travelorInformation");    //get all nodes matching with this xpath
		Assert.assertEquals(TravelorList.size(), 10);
	}

	
	//@Test(priority = 4)
		public void verifyTraveleNamePresentInList() 
		{
			//approch2: with returning/storing response
			//validate dynamic data 
			
			Response resp = given()
			.when() .get("http://restapi.adequateshop.com/api/Traveler?page=1");
			
			XmlPath x=new XmlPath(resp.asString());  //convert entire response into string format
			List<String> TravelorNames = x.getList("TravelorInformationResponse.travelor.travelorInformation.name");    //get all nodes matching with this xpath
		
			boolean nameFound=false;
			for(String name:TravelorNames)
			{
				if(name.equals("Vijay bharatrao reddy"))
				{
					nameFound=true;
					break;
				}
			}
			
			Assert.assertEquals(nameFound, true, "Failed: name not found in Traveler list");
		}
	
}

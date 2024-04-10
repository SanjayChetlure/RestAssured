package Day5_Parsing_XML_ResponseBody_JSONPath_And_FileUpload_Download;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload 
{
	@Test(priority = 1)
	public void singleFileUpload() 
	{
		File f=new File("path of file upload");
		given()
			//thse 2 steps are imp in file upload (multiPart  & contentType)
			.multiPart("file",f)                      //specify form data
			.contentType("multipart/form-data")      
		
		.when()
			.post("request URL")
		
		.then()
			.statusCode(200)
			.body("filename", equalTo("text.txt"))
			.log().all();
	}
	
	
	@Test(priority = 2)
	public void multipleFileUpload1() 
	{
		File f1=new File("path of 1st file upload");
		File f2=new File("path of 2nd file upload");
		given()
			//thse 2 steps are imp in file upload (multiPart  & contentType)
			.multiPart("files",f1)    
			.multiPart("files",f2)    
			.contentType("multipart/form-data")      
		
		.when()
			.post("request URL")
		
		.then()
			.statusCode(200)
			.body("[0].filename", equalTo("text1.txt"))
			.body("[1].filename", equalTo("text2.txt"))
			.log().all();
	}
	
	
	@Test(priority = 3)
	public void multipleFileUpload2() 
	{
		File f1=new File("path of 1st file upload");
		File f2=new File("path of 2nd file upload");
		File ar[]= {f1,f2};
		
		
		given()
			//this is another way where we can store multiple files path in File array
			//but sometimes its may not work for few api, depends on developers
			.multiPart("files",ar)     
			.contentType("multipart/form-data")      
		
		.when()
			.post("post request URL")
		
		.then()
			.statusCode(200)
			.body("[0].filename", equalTo("text1.txt"))
			.body("[1].filename", equalTo("text2.txt"))
			.log().all();
	}
	
	
	@Test(priority = 4)
	public void fileDownload() 
	{
		given()
		
		.when()
			.get("get request URL")
		
		.then()
			.statusCode(200)
			.log().body();
	}
}

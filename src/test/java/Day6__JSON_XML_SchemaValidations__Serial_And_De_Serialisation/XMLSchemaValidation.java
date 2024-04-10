package Day6__JSON_XML_SchemaValidations__Serial_And_De_Serialisation;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;


public class XMLSchemaValidation
{
	@Test
	public void jsonSchemaValidation()
	{
		given()
		.when()
			.get("request url")
		.then()	
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("XMLSchema.xsd") );
	}
}

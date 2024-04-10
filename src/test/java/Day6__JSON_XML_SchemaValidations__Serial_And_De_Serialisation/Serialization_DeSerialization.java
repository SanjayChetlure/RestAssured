package Day6__JSON_XML_SchemaValidations__Serial_And_De_Serialisation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//POJO class-- Serialization -- JSON Object -- De-serialization  -- POJO Class

public class Serialization_DeSerialization
{
	
	//Convert Java -> JSON
	@Test(priority = 1)
	public void convertPOJO2Json() throws JsonProcessingException 
	{
		//Creating Java Object using POJO class
		Student stuPojo=new Student();    //POJO
		stuPojo.setName("abc1");
		stuPojo.setLocation("india");
		stuPojo.setPhone("1111");
		
		String [] cources= {"c", "c++"};
		stuPojo.setCources(cources);		
		
		//convert Java object to Json Object   (Serialization)
		ObjectMapper objMap=new ObjectMapper();                  //import from jackson.databind package
		String jsonData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(stuPojo);
	
		System.out.println(jsonData);
	}	
	
	//convert Json -> Pojo     (De-Serialization)
	@Test(priority = 2)
	public void convertJsonToPOJO() throws JsonProcessingException 
	{
		String jsonData="{\r\n"
				+ "  \"name\" : \"abc1\",\r\n"
				+ "  \"location\" : \"india\",\r\n"
				+ "  \"phone\" : \"1111\",\r\n"
				+ "  \"cources\" : [ \"c\", \"c++\" ]\r\n"
				+ "}";
		
		//convert Json Object to Java object     (De-Serialization)
		ObjectMapper objMap=new ObjectMapper();      //import from jackson.databind package
		Student stuPojo = objMap.readValue(jsonData, Student.class);
		
		System.out.println("Name: "+stuPojo.getName());
		System.out.println("Phone: "+stuPojo.getPhone());
		System.out.println("Location: "+stuPojo.getLocation());
		System.out.println("Cource1: "+stuPojo.getCources()[0]);
		System.out.println("Cource2: "+stuPojo.getCources()[1]);
	}	
	

}

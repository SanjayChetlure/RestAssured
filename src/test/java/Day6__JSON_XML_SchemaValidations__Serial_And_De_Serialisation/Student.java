package Day6__JSON_XML_SchemaValidations__Serial_And_De_Serialisation;
public class Student
{
	String name;
	String location;
	String phone;
	String cources [];
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCources() {
		return cources;
	}
	public void setCources(String[] cources) {
		this.cources = cources;
	}
}

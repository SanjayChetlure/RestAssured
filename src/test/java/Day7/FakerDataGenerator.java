package Day7;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator 
{
	@Test
	public void FakerLibraryDataGenerator()
	{
		Faker f=new Faker();
		
		System.out.println(f.name().firstName());
		System.out.println(f.name().lastName());
		System.out.println(f.name().fullName());
		
		System.out.println(f.name().username());
		System.out.println(f.internet().password());
		
		System.out.println(f.phoneNumber().cellPhone());
		System.out.println(f.internet().emailAddress());
		System.out.println(f.internet().safeEmailAddress());
		
		System.out.println(f.business().creditCardExpiry());
		System.out.println(f.business().creditCardNumber());
		
		System.out.println(f.color().name());
		
		System.out.println(f.animal().name());
	}
}

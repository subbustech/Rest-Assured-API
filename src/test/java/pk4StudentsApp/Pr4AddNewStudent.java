package pk4StudentsApp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pk0Resources.Payload;
import pk0Resources.Resources;

public class Pr4AddNewStudent {
	
	Properties prop = new Properties();
	
	@BeforeTest
	public void getProperties() throws IOException {
		
		FileInputStream fis = new FileInputStream("Resources\\env.properties");
		prop.load(fis);
		
	}
	
	@Test
	public void addNewStudent() {
		
		String postBody = Payload.returnAddNewStudentBody();
		
		RestAssured.baseURI = prop.getProperty("HOST");

		given().
			body(postBody).
			contentType("application/json").
			when().
				post(Resources.returnAddNewStudentEndUrl()).
				then().
					assertThat().body("msg",equalTo("Student added"));
	}
}
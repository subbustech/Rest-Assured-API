package pk4StudentsApp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pk0Resources.Resources;

public class Pr1GetAllStudents {
	
	Properties prop = new Properties();
	
	@BeforeTest
	public void getProperties() throws IOException {
		
		FileInputStream fis = new FileInputStream("Resources\\env.properties");
		prop.load(fis);
		
	}
	
	@Test
	public void getAllStudents() {
		
		RestAssured.baseURI = prop.getProperty("HOST");

		given().
				when().
					get(Resources.returnAllStudentsEndUrl()).
					then().
						assertThat().statusCode(200).and().
						contentType(ContentType.JSON).and().
						body("[0].firstName",equalTo("Vernon")).and().
						body("[0].lastName", equalTo("Harper")).and().
						body("[0].courses[0]", equalTo("Accounting")).and().
						body("[0].courses[1]", equalTo("Statistics")).and().
						body("size()", equalTo(100));
	}
}

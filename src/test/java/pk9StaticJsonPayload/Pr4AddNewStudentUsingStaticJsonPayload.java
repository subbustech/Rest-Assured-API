package pk9StaticJsonPayload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pk0Resources.CommonFunctions;
import pk0Resources.Payload;
import pk0Resources.Resources;

public class Pr4AddNewStudentUsingStaticJsonPayload {
	
	Properties prop = new Properties();
	
	@BeforeTest
	public void getProperties() throws IOException {
		
		FileInputStream fis = new FileInputStream("Resources\\env.properties");
		prop.load(fis);
		
	}
	
	@Test
	public void addNewStudent() throws IOException {
		
		RestAssured.baseURI = prop.getProperty("HOST");
		

		Response res = given().
			body(GenerateStringFromResource("Resources\\addNewStudent.json")).
			contentType("application/json").
			when().
				post(Resources.returnAddNewStudentEndUrl()).
				then().
					assertThat().body("msg",equalTo("Student added")).
					extract().response();
		
		JsonPath resJson = CommonFunctions.returnJsonBody(res);
	}
	
	public static String GenerateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
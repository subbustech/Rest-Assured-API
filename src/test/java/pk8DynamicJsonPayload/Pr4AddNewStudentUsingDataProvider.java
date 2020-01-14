package pk8DynamicJsonPayload;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileInputStream;
import java.io.IOException;
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

public class Pr4AddNewStudentUsingDataProvider {
	
	Properties prop = new Properties();
	
	@BeforeTest
	public void getProperties() throws IOException {
		
		FileInputStream fis = new FileInputStream("Resources\\env.properties");
		prop.load(fis);
		
	}
	
	@Test(dataProvider="empData")
	public void addNewStudent(String firstName, String lastName, String email) {
		
		String postBody = Payload.returnAddNewStudentBodyWithParams(firstName, lastName, email);
		
		RestAssured.baseURI = prop.getProperty("HOST");
		

		Response res = given().
			body(postBody).
			contentType("application/json").
			when().
				post(Resources.returnAddNewStudentEndUrl()).
				then().
					assertThat().body("msg",equalTo("Student added")).
					extract().response();
		
		JsonPath resJson = CommonFunctions.returnJsonBody(res);
	}
	
	@DataProvider(name = "empData")
	public Object[][] getData() {
		return new Object[][] {{"Raj", "Kumar", "raj@gmail.com"}, {"Ganesh", "Kumar", "ganesh@gmail.com"}, {"Suresh", "Kumar", "suresh@gmail.com"}};  
	}
}
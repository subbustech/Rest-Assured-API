package pk2StudentsApp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Pr4AddNewStudent {
	@Test
	public void addNewStudent() {
		
		RestAssured.baseURI = "http://localhost:8090";

		given().
			body("{"+
				    "\"firstName\": \"Venkat\","+
				    "\"lastName\": \"Dinavahi\","+
				    "\"email\": \"venkat@gmail.com\","+
				    "\"programme\": \"Computer Science\","+
				    "\"courses\": ["+
				        "\"Java\","+
				        "\"Php\","+
				        "\"Data Science\""+
				    "]"+
				"}").
			contentType("application/json").
			when().
				post("/student").
				then().
					assertThat().body("msg",equalTo("Student added"));
	}
}
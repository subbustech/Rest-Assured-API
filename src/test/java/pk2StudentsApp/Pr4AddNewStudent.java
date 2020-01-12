package pk2StudentsApp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Pr4AddNewStudent {
	@Test
	public void addNewStudent() {
		
		String postBody = "{"+
			    "\"firstName\": \"Venkat\","+
			    "\"lastName\": \"Dinavahi\","+
			    "\"email\": \"venkat@gmail.com\","+
			    "\"programme\": \"Computer Science\","+
			    "\"courses\": ["+
			        "\"Java\","+
			        "\"Php\","+
			        "\"Data Science\""+
			    "]"+
			"}";
		
		RestAssured.baseURI = "http://localhost:8090";

		given().
			body(postBody).
			contentType("application/json").
			when().
				post("/student").
				then().
					assertThat().body("msg",equalTo("Student added"));
	}
}
package pk2StudentsApp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Pr9AddNewStudentAndDeleteTheStudentJson {
	@Test
	public void addNewStudentAndDeleteStudent() {

		//Request Body to Post New Student
		String requestBody = "{"+
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

		//Post New Student
		given().
		body(requestBody).
		contentType("application/json").
		when().
		post("/student").
		then().
		assertThat().body("msg",equalTo("Student added"));

		System.out.println("New Student Added Successfully");

		//Get the last student id
		Response res = given().
				when().
				get("student/list").
				then().
				assertThat().statusCode(200).and().
				contentType(ContentType.JSON).and().
				extract().response();

		//Convert the raw format of res into String
		String resBody = res.asString();

		//Convert the string into json
		JsonPath jsonBody = new JsonPath(resBody);

		//Access the values from json
		//Get the size from JSON response
		int totalJson = jsonBody.getList("").size();

		//Get last student id
		int lastStudentIdJson = jsonBody.get("["+(totalJson-1)+"].id");
		System.out.println("Last Student Id "+lastStudentIdJson);

		
		//Delete New Student Added
		given().
		when().
		delete("student/"+lastStudentIdJson).
		then().
		assertThat().statusCode(204);
		System.out.println("New Student Added Successfully Deleted.");
	}
}

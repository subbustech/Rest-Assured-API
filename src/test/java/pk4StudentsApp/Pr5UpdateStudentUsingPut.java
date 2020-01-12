package pk4StudentsApp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Pr5UpdateStudentUsingPut {
	@Test
	public void UpdateStudentUsingPut() {

		String postBody = "{"+
				"\"firstName\": \"Venkata Rao\","+
				"\"lastName\": \"Dinavahi\","+
				"\"email\": \"venkat123@gmail.com\","+
				"\"programme\": \"Computer Science\","+
				"\"courses\": ["+
				"\"Java\","+
				"\"Php\","+
				"\"Data Science\","+
				"\"C Language\""+
				"]"+
				"}";

		RestAssured.baseURI = "http://localhost:8090";

		/**************************************************************
		 ****************** Get the last student id *******************
		 **************************************************************/
		
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
		
		System.out.println("lastStudentIdJson :"+lastStudentIdJson);

		/********************************************************************
		 ********************** Update Last Student Id **********************
		 ********************************************************************/

		given().
		body(postBody).
		contentType("application/json").
		pathParam("studentId", lastStudentIdJson).
		log().all().
		when().
			put("/student/{studentId}").
			then().
				assertThat().body("msg",equalTo("Student Updated"));
	}
}
package pk2StudentsApp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Pr2GetStudentsWithProgramme {
	@Test
	public void getAllStudents() {
		
		RestAssured.baseURI = "http://localhost:8090/";

		given().
			queryParam("programme","Financial Analysis").
				when().
					get("student/list").
					then().
						assertThat().statusCode(200).and().
						contentType(ContentType.JSON).and().
						body("[0].firstName",equalTo("Vernon")).and().
						body("[0].lastName", equalTo("Harper")).and().
						body("[0].courses[0]", equalTo("Accounting")).and().
						body("[0].courses[1]", equalTo("Statistics"));
	}
}
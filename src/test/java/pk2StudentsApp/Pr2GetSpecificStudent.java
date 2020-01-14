package pk2StudentsApp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Pr2GetSpecificStudent {
	@Test
	public void getAllStudents() {
		
		RestAssured.baseURI = "http://localhost:8090";

		given().
			log().all().
			pathParam("studentid", "1").
				when().
					get("/student/{studentid}").
					then().log().all().
						assertThat().statusCode(200).and().
						contentType(ContentType.JSON).and().
						body("firstName",equalTo("Vernon")).and().
						body("lastName", equalTo("Harper")).and().
						body("courses[0]", equalTo("Accounting")).and().
						body("courses[1]", equalTo("Statistics")).and().
						body("size()", equalTo(6));
	}
}
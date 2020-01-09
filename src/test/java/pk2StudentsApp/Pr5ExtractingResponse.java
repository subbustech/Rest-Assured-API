package pk2StudentsApp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Pr5ExtractingResponse {
	@Test
	public void extractAllStudents() {
		
		RestAssured.baseURI = "http://localhost:8090/";

		Response res = given().
				when().
					get("student/list").
					then().
						assertThat().statusCode(200).and().
						contentType(ContentType.JSON).and().
						body("[0].firstName",equalTo("Vernon")).and().
						body("[0].lastName", equalTo("Harper")).and().
						body("[0].courses[0]", equalTo("Accounting")).and().
						body("[0].courses[1]", equalTo("Statistics")).and().
						body("size()", equalTo(100)).and().
						extract().response();
		
		//Convert the raw format of res into String
		String resBody = res.asString();
		System.out.println(resBody);
		
		//Convert the string into json
		JsonPath jsonBody = new JsonPath(resBody);
		
		//Extract the values now
		int total = res.body().path("list.size()");
		int lastStudentId = res.body().path("["+(total-1)+"].id");
		System.out.println("Last Student Id "+lastStudentId);
		
		System.out.println(jsonBody.get("[0].id"));
		System.out.println(jsonBody.getList("").size());
	}
}

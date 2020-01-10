package pk2StudentsApp;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

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

		System.out.println("****************************************************************");
		System.out.println("*************** Getting Values From Raw Response ***************");
		System.out.println("****************************************************************");
		
		//Getting the values using raw response

		//Get the size of the array in response
		int total = res.body().path("list.size()");

		//Get last student id
		int lastStudentId = res.body().path("["+(total-1)+"].id");
		System.out.println("Last Student Id "+lastStudentId);

		//Get Last Student First Name
		System.out.println(res.body().path("["+(total-1)+"].firstName"));

		//Get Last Student Last Name
		System.out.println(res.body().path("["+(total-1)+"].lastName"));

		//Get Last Student Email
		System.out.println(res.body().path("["+(total-1)+"].email"));

		//Get Last Student Program
		System.out.println(res.body().path("["+(total-1)+"].programme"));

		//Get the Last Student's courses
		List<String> courses = res.body().path("["+(total-1)+"].courses");
		System.out.println("Courses.......... ");
		for(String course : courses) {
			System.out.println(course);
		}

		//You can also access the individual courses as
		System.out.println("Accessing The Courses Individually..........");
		System.out.println(res.body().path("["+(total-1)+"].courses[0]"));
		System.out.println(res.body().path("["+(total-1)+"].courses[1]"));
		System.out.println(res.body().path("["+(total-1)+"].courses[2]"));

		System.out.println("****************************************************************");
		System.out.println("******** Converting Raw Response To String and Printing ********");
		System.out.println("****************************************************************");
		
		//Converting the raw format into json
		//First we need to convert it into String and then to json

		//Convert the raw format of res into String
		String resBody = res.asString();
		System.out.println(resBody);

		System.out.println("****************************************************************");
		System.out.println("************ Getting the Values from JSON Response *************");
		System.out.println("****************************************************************");
		
		//Convert the string into json
		JsonPath jsonBody = new JsonPath(resBody);

		//Access the values from json
		//Get the size from JSON response
		int totalJson = jsonBody.getList("").size();

		//Get last student id
		int lastStudentIdJson = jsonBody.get("["+(totalJson-1)+"].id");
		System.out.println("Last Student Id "+lastStudentIdJson);

		//Get Last Student First Name
		System.out.println(jsonBody.get("["+(totalJson-1)+"].firstName"));

		//Get Last Student Last Name
		System.out.println(jsonBody.get("["+(totalJson-1)+"].lastName"));

		//Get Last Student Email
		System.out.println(jsonBody.get("["+(totalJson-1)+"].email"));

		//Get Last Student Program
		System.out.println(jsonBody.get("["+(totalJson-1)+"].programme"));

		//Get the Last Student's courses
		List<String> coursesJson = jsonBody.get("["+(totalJson-1)+"].courses");
		System.out.println("Courses.......... ");
		for(String course : coursesJson) {
			System.out.println(course);
		}

		//You can also access the individual courses as
		System.out.println("Accessing The Courses Individually..........");
		System.out.println(jsonBody.get("["+(totalJson-1)+"].courses[0]"));
		System.out.println(jsonBody.get("["+(totalJson-1)+"].courses[1]"));
		System.out.println(jsonBody.get("["+(totalJson-1)+"].courses[2]"));

	}
}
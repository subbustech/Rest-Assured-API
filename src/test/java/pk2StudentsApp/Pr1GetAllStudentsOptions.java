package pk2StudentsApp;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Pr1GetAllStudentsOptions {
	@Test
	public void getAllStudents() {
		
		RestAssured.baseURI = "http://localhost:8090/";

		Response res = given().
				log().all().
				when().
					options("student/list").
					then().
						extract().response();
		System.out.println(res.header("Allow"));
	}
}

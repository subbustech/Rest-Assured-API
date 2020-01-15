package pk11PojoClassesAdvanced;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

public class Pr2GetSpecificStudent {
	@Test
	public void getAllStudents() {
		
		RestAssured.baseURI = "http://localhost:8090";

		GetStudent gs = given().
			log().all().
			pathParam("studentid", "1").
			//expect().defaultParser(Parser.JSON). This is not needed if the response Content-Type is application/json
				when().
					get("/student/{studentid}").as(GetStudent.class);
		
		System.out.println("Id : "+gs.getId());
		System.out.println("First Name : "+gs.getFirstName());
		System.out.println("Last Name : "+gs.getLastName());
		System.out.println("Programme : "+gs.getProgramme());
		System.out.println("Email : "+gs.getEmail());
		
		int noOfCourses = gs.getCourses().size();
		
		for(int i=0; i<noOfCourses; i++) {
			System.out.println("Course "+i+" : "+gs.getCourses().get(i));
		}
	}
}
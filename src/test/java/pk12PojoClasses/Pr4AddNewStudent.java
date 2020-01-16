package pk12PojoClasses;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Pr4AddNewStudent {
	@Test
	public void addNewStudent() {
		
		PostStudent ps = new PostStudent();
		ps.setFirstName("Raju");
		ps.setLastName("Venkata");
		ps.setEmail("VenkataRaju1@gmail.com");
		ps.setProgramme("Law");
		
		List<String> courses = new ArrayList<String>(Arrays.asList("Java","PHP","C++","Javascript"));
		ps.setCourses(courses);
				
		RestAssured.baseURI = "http://localhost:8090";

		given().
			body(ps).log().all().
			contentType("application/json").
			when().
				post("/student").
				then().
					assertThat().body("msg",equalTo("Student added"));
	}
}
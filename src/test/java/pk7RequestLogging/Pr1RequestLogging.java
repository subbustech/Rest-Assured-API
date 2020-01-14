package pk7RequestLogging;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Pr1RequestLogging {
	@Test
	public void getAllStudents() {
		
		RestAssured.baseURI = "http://localhost:8090/";

		given().
			queryParam("programme","Financial Analysis").and().
			queryParam("limit", "3").
			//log().all().
			//log().params().
			//log().body().
			//log().headers().
			//log().cookies().
			//log().method().
				when().
					get("student/list").
					then().
						assertThat().statusCode(200).
						//log().body();
						//log().ifError();
						//log().all();
						//log().status();
						//log().headers();
						//log().cookies();
						log().ifStatusCodeIsEqualTo(200);
	}
}

package pk1FirstPackage;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

public class Pr1GoogleBooksAPI {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "https://www.googleapis.com/";

		given().
				param("q","java").
				when().
				get("books/v1/volumes").
				then().assertThat().statusCode(100);
				
	}

}

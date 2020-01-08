package pk1GoogleBooksApi;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class Pr1GoogleBooksAPI {

	@Test
	public void googleBookStore() {
		
		RestAssured.baseURI = "https://www.googleapis.com/";

		given().
				param("q","java").
				when().
					get("books/v1/volumes").
					then().
						assertThat().statusCode(200).and().
						contentType(ContentType.JSON).and().
						body("totalItems", equalTo(2640)).and().
						body("items[0].volumeInfo.title", equalTo("The Class Of Java")).and().
						body("items[1].volumeInfo.title", equalTo("Programming with Java")).and().
						header("Server", "GSE");
	}
}
